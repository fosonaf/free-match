package com.freematch.server.adapter.persistence.field

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface JpaFieldRepository : JpaRepository<JpaFieldEntity, UUID>