package com.freematch.server.adapter.persistence.match

import com.freematch.server.adapter.persistence.player.JpaPlayerRepository
import com.freematch.server.adapter.persistence.slot.JpaSlotRepository
import com.freematch.server.domain.match.model.Match
import com.freematch.server.domain.match.port.MatchPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class MatchRepositoryAdapter(
    private val jpaRepo: JpaMatchRepository,
    private val slotRepo: JpaSlotRepository,
    private val playerRepo: JpaPlayerRepository
) : MatchPort {

    override fun save(match: Match): Match {
        val slot = slotRepo.findById(match.slotId).orElseThrow()
        val creator = playerRepo.findById(match.creatorId).orElseThrow()
        val participants = match.participantIds
            .map { playerRepo.findById(it).orElseThrow() }
            .toMutableSet()

        val entity = JpaMatchEntity(
            id = match.id,
            slot = slot,
            creator = creator,
            participants = participants,
            recommendedPlayers = match.recommendedPlayers,
            status = match.status,
            createdAt = match.createdAt
        )
        return jpaRepo.save(entity).toDomain()
    }

    override fun findById(id: UUID): Match? =
        jpaRepo.findById(id).map { it.toDomain() }.orElse(null)
}
