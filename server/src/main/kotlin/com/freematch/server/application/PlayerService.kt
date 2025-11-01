package com.freematch.server.application

import com.freematch.server.domain.player.model.Player
import com.freematch.server.domain.port.PlayerPort
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerService(
    private val playerPort: PlayerPort
) {
    fun getAllPlayers(): List<Player> = playerPort.findAll()

    fun getPlayer(id: UUID): Player? = playerPort.findById(id)

    fun createPlayer(username: String, age: Int, avatarUrl: String?): Player {
        val player = Player(
            id = UUID.randomUUID(),
            username = username,
            age = age,
            avatarUrl = avatarUrl
        )
        return playerPort.save(player)
    }
}