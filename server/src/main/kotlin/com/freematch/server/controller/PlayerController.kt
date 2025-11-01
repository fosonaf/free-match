package com.freematch.server.controller

import com.freematch.server.dto.CreatePlayerRequest
import com.freematch.server.dto.PlayerResponse
import com.freematch.server.model.Player
import com.freematch.server.model.toResponse
import com.freematch.server.repository.PlayerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/players")
class PlayerController(
    private val playerRepo: PlayerRepository
) {

    @GetMapping
    fun getAllPlayers(): List<PlayerResponse> {
        return playerRepo.findAll().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getPlayer(@PathVariable id: UUID): ResponseEntity<PlayerResponse> {
        return playerRepo.findById(id)
            .map { ResponseEntity.ok(it.toResponse()) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createPlayer(@RequestBody request: CreatePlayerRequest): PlayerResponse {
        val player = Player(
            id = UUID.randomUUID(),
            username = request.username,
            age = request.age,
            avatarUrl = request.avatarUrl
        )
        return playerRepo.save(player).toResponse()
    }
}