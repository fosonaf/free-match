// adapter/web/dto/MatchResponse.kt
package com.freematch.server.adapter.web.match.dto

import com.freematch.server.domain.match.model.Match
import com.freematch.server.domain.match.model.MatchStatus
import java.time.LocalDateTime
import java.util.UUID

data class MatchResponse(
    val id: UUID,
    val slotId: UUID,
    val creatorId: UUID,
    val participantIds: List<UUID>,
    val recommendedPlayers: Int,
    val status: MatchStatus,
    val createdAt: LocalDateTime
)

// Extension dans le domaine → import dans le controller
fun Match.toResponse() = MatchResponse(
    id = id,
    slotId = slotId,
    creatorId = creatorId,
    participantIds = participantIds,
    recommendedPlayers = recommendedPlayers,
    status = status,
    createdAt = createdAt
)
