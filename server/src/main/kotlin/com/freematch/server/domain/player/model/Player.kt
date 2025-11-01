package com.freematch.server.domain.player.model

import com.freematch.server.adapter.web.player.dto.PlayerResponse
import java.util.UUID

data class Player(
    val id: UUID = UUID.randomUUID(),
    val username: String,
    val age: Int,
    val avatarUrl: String? = null
)

fun Player.toResponse(): PlayerResponse = PlayerResponse(
    id = this.id,
    username = this.username,
    age = this.age,
    avatarUrl = this.avatarUrl
)