package com.freematch.server.adapter.web.player.controller

import com.freematch.server.application.PlayerService
import com.freematch.server.domain.player.model.toResponse
import com.freematch.server.adapter.web.player.dto.CreatePlayerRequest
import com.freematch.server.adapter.web.player.dto.PlayerResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/players")
class PlayerController(
    private val playerService: PlayerService
) {

    @GetMapping
    fun getAllPlayers(): List<PlayerResponse> {
        return playerService.getAllPlayers().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getPlayer(@PathVariable id: UUID): ResponseEntity<PlayerResponse> {
        return playerService.getPlayer(id)
            ?.let { ResponseEntity.ok(it.toResponse()) }
            ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createPlayer(@RequestBody request: CreatePlayerRequest): PlayerResponse {
        val player = playerService.createPlayer(
            username = request.username,
            age = request.age,
            avatarUrl = request.avatarUrl
        )
        return player.toResponse()
    }
}