package com.freematch.server.application

import com.freematch.server.domain.slot.model.Slot
import com.freematch.server.domain.slot.port.SlotPort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SlotService(
    private val slotPort: SlotPort
) {
    fun getSlotsByField(fieldId: UUID): List<Slot> = slotPort.findByFieldId(fieldId)
}