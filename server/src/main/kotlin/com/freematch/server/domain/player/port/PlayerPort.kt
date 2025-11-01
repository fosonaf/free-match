package com.freematch.server.domain.port

import com.freematch.server.domain.player.model.Player
import java.util.*

interface PlayerPort {
    fun findAll(): List<Player>
    fun findById(id: UUID): Player?
    fun save(player: Player): Player
}