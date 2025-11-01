package com.freematch.server.adapter.persistence.player

import com.freematch.server.domain.player.model.Player
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "players")
data class JpaPlayerEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val username: String,

    val age: Int,

    @Column(name = "avatar_url")
    val avatarUrl: String? = null
)

// Conversions
fun JpaPlayerEntity.toDomain() = Player(
    id = this.id,
    username = this.username,
    age = this.age,
    avatarUrl = this.avatarUrl
)

fun Player.toEntity() = JpaPlayerEntity(
    id = this.id,
    username = this.username,
    age = this.age,
    avatarUrl = this.avatarUrl
)