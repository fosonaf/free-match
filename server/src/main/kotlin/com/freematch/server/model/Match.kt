package com.freematch.server.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "matches")
data class Match(
    @Id @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "slot_id", nullable = false)
    val slot: Slot,

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    val creator: Player,

    @ElementCollection
    val participantIds: MutableList<UUID> = mutableListOf(),

    val recommendedPlayers: Int,

    @Enumerated(EnumType.STRING)
    var status: MatchStatus = MatchStatus.CREATED,

    val createdAt: LocalDateTime = LocalDateTime.now()
)

enum class MatchStatus {
    CREATED, VALIDATED, CANCELLED, COMPLETED
}
