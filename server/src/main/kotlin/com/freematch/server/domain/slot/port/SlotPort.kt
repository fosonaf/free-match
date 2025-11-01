package com.freematch.server.domain.slot.port

import com.freematch.server.domain.slot.model.Slot
import java.util.UUID

interface SlotPort {
    fun save(slot: Slot): Slot
    fun findById(id: UUID): Slot?
    fun findByFieldId(fieldId: UUID): List<Slot>
}
