package com.freematch.server.application

import com.freematch.server.domain.match.model.Match
import com.freematch.server.domain.match.model.MatchStatus
import com.freematch.server.domain.match.port.MatchPort
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class MatchService(
    private val matchPort: MatchPort
) {
    fun createMatch(
        slotId: UUID,
        creatorId: UUID,
        recommendedPlayers: Int
    ): Match {
        val match = Match(
            id = UUID.randomUUID(),
            slotId = slotId,
            creatorId = creatorId,
            recommendedPlayers = recommendedPlayers,
            status = MatchStatus.CREATED,
            createdAt = LocalDateTime.now()
        )
        return matchPort.save(match)
    }

    fun getMatch(id: UUID): Match? = matchPort.findById(id)
}
