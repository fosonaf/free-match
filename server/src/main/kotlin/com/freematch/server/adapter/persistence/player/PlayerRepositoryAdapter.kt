package com.freematch.server.adapter.persistence.player

import com.freematch.server.domain.player.model.Player
import com.freematch.server.domain.port.PlayerPort
import org.springframework.stereotype.Component
import java.util.*

@Component
class PlayerRepositoryAdapter(
    private val jpaRepo: JpaPlayerRepository
) : PlayerPort {

    override fun findAll(): List<Player> =
        jpaRepo.findAll().map { it.toDomain() }

    override fun findById(id: UUID): Player? =
        jpaRepo.findById(id).map { it.toDomain() }.orElse(null)

    override fun save(player: Player): Player =
        jpaRepo.save(player.toEntity()).toDomain()
}