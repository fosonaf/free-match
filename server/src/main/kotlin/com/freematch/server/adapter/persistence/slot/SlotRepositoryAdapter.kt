package com.freematch.server.adapter.persistence.slot

import com.freematch.server.adapter.persistence.field.JpaFieldRepository
import com.freematch.server.domain.slot.model.Slot
import com.freematch.server.domain.slot.port.SlotPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SlotRepositoryAdapter(
    private val jpaRepo: JpaSlotRepository,
    private val fieldRepo: JpaFieldRepository
) : SlotPort {

    override fun save(slot: Slot): Slot {
        val field = fieldRepo.findById(slot.fieldId).orElseThrow()
        return jpaRepo.save(slot.toEntity(field)).toDomain()
    }

    override fun findById(id: UUID): Slot? =
        jpaRepo.findById(id).map { it.toDomain() }.orElse(null)

    override fun findByFieldId(fieldId: UUID): List<Slot> =
        jpaRepo.findByFieldId(fieldId).map { it.toDomain() }
}