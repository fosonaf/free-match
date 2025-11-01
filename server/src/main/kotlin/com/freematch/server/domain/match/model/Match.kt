package com.freematch.server.domain.match.model

import com.freematch.server.adapter.web.match.dto.MatchResponse
import java.time.LocalDateTime
import java.util.UUID

data class Match(
    val id: UUID = UUID.randomUUID(),
    val slotId: UUID,
    val creatorId: UUID,
    val participantIds: MutableList<UUID> = mutableListOf(),
    val recommendedPlayers: Int,
    var status: MatchStatus = MatchStatus.CREATED,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

enum class MatchStatus { CREATED, VALIDATED, CANCELLED, COMPLETED }

// EXTENSION ICI
fun Match.toResponse() = MatchResponse(
    id = id,
    slotId = slotId,
    creatorId = creatorId,
    participantIds = participantIds,
    recommendedPlayers = recommendedPlayers,
    status = status,
    createdAt = createdAt
)