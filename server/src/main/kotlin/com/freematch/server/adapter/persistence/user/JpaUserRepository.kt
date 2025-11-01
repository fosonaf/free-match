package com.freematch.server.adapter.persistence.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface JpaUserRepository : JpaRepository<JpaUserEntity, UUID> {
    fun findByEmail(email: String): JpaUserEntity?
}