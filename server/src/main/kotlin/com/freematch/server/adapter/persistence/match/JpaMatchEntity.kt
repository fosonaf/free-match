package com.freematch.server.adapter.persistence.match

import com.freematch.server.adapter.persistence.player.JpaPlayerEntity
import com.freematch.server.adapter.persistence.slot.JpaSlotEntity
import com.freematch.server.domain.match.model.Match
import com.freematch.server.domain.match.model.MatchStatus
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "matches")
data class JpaMatchEntity(
    @Id @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "slot_id", nullable = false)
    val slot: JpaSlotEntity,

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    val creator: JpaPlayerEntity,  // OK : @Entity

    @ManyToMany
    @JoinTable(
        name = "match_participants",
        joinColumns = [JoinColumn(name = "match_id")],
        inverseJoinColumns = [JoinColumn(name = "player_id")]
    )
    val participants: MutableSet<JpaPlayerEntity> = mutableSetOf(),

    val recommendedPlayers: Int,

    @Enumerated(EnumType.STRING)
    var status: MatchStatus = MatchStatus.CREATED,

    val createdAt: LocalDateTime = LocalDateTime.now()
)

// Conversions
fun JpaMatchEntity.toDomain() = Match(
    id = this.id,
    slotId = this.slot.id,
    creatorId = this.creator.id,
    participantIds = this.participants.map { it.id }.toMutableList(),
    recommendedPlayers = this.recommendedPlayers,
    status = this.status,
    createdAt = this.createdAt
)

fun Match.toEntity(
    slot: JpaSlotEntity,
    creator: JpaPlayerEntity,
    participants: Set<JpaPlayerEntity>
) = JpaMatchEntity(
    id = this.id,
    slot = slot,
    creator = creator,
    participants = participants.toMutableSet(),
    recommendedPlayers = this.recommendedPlayers,
    status = this.status,
    createdAt = this.createdAt
)