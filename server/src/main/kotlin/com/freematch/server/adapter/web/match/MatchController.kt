package com.freematch.server.adapter.web.match

import com.freematch.server.adapter.web.match.dto.CreateMatchRequest
import com.freematch.server.adapter.web.match.dto.MatchResponse
import com.freematch.server.domain.match.model.toResponse
import com.freematch.server.application.MatchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/matches")
class MatchController(
    private val matchService: MatchService
) {

    @PostMapping
    fun createMatch(@RequestBody request: CreateMatchRequest): MatchResponse {
        return matchService.createMatch(
            slotId = request.slotId,
            creatorId = request.creatorId,
            recommendedPlayers = request.recommendedPlayers
        ).toResponse()
    }

    @GetMapping("/{id}")
    fun getMatch(@PathVariable id: UUID): ResponseEntity<MatchResponse> {
        return matchService.getMatch(id)
            ?.let { ResponseEntity.ok(it.toResponse()) }
            ?: ResponseEntity.notFound().build()
    }
}