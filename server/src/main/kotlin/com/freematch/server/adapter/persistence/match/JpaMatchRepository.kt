package com.freematch.server.adapter.persistence.match

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface JpaMatchRepository : JpaRepository<JpaMatchEntity, UUID>