package com.freematch.server.adapter.persistence.player

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface JpaPlayerRepository : JpaRepository<JpaPlayerEntity, UUID>