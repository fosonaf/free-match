package com.freematch.server.domain.slot.model

import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

data class Slot(
    val id: UUID = UUID.randomUUID(),
    val fieldId: UUID,
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val isAvailable: Boolean
)
