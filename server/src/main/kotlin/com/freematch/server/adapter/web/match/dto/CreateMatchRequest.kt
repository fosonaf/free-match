package com.freematch.server.adapter.web.match.dto

import java.util.UUID

data class CreateMatchRequest(
    val slotId: UUID,
    val creatorId: UUID,
    val recommendedPlayers: Int
)