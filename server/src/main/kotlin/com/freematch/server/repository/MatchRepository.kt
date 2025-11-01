package com.freematch.server.repository

import com.freematch.server.model.Match
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MatchRepository : JpaRepository<Match, UUID>
