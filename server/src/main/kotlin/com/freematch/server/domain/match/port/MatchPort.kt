package com.freematch.server.domain.match.port

import com.freematch.server.domain.match.model.Match
import java.util.UUID

interface MatchPort {
    fun save(match: Match): Match
    fun findById(id: UUID): Match?
}