package com.freematch.server.adapter.persistence.slot

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface JpaSlotRepository : JpaRepository<JpaSlotEntity, UUID> {
    fun findByFieldId(fieldId: UUID): List<JpaSlotEntity>
}