// server/src/main/kotlin/com/freematch/server/model/Player.kt
package com.freematch.server.model

import com.freematch.server.dto.PlayerResponse
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "players")
data class Player(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val username: String,

    val age: Int,

    @Column(name = "avatar_url")
    val avatarUrl: String? = null  // nullable
)

// FONCTION D'EXTENSION → dans le même fichier
fun Player.toResponse(): PlayerResponse = PlayerResponse(
    id = this.id,
    username = this.username,
    age = this.age,
    avatarUrl = this.avatarUrl
)