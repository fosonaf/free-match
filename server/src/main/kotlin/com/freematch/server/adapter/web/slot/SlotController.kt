package com.freematch.server.adapter.web.slot

import com.freematch.server.adapter.web.slot.dto.SlotResponse
import com.freematch.server.adapter.web.slot.dto.toResponse
import com.freematch.server.application.SlotService
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/slots")
class SlotController(
    private val slotService: SlotService
) {
    @GetMapping("/field/{fieldId}")
    fun getSlotsByField(@PathVariable fieldId: UUID): List<SlotResponse> =
        slotService.getSlotsByField(fieldId).map { it.toResponse() }
}
