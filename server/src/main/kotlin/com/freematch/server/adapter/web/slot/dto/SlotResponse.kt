package com.freematch.server.adapter.web.slot.dto

import com.freematch.server.domain.slot.model.Slot
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

data class SlotResponse(
    val id: UUID,
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val isAvailable: Boolean
)

fun Slot.toResponse() = SlotResponse(id, date, startTime, endTime, isAvailable)