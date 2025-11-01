package com.freematch.server.adapter.web.player.dto

import java.util.UUID

data class PlayerResponse(
    val id: UUID,
    val username: String,
    val age: Int,
    val avatarUrl: String? = null
)

data class CreatePlayerRequest(
    val username: String,
    val age: Int,
    val avatarUrl: String? = null
)