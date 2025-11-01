package com.freematch.server.repository

import com.freematch.server.model.Player
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PlayerRepository : JpaRepository<Player, UUID>
