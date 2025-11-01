package com.freematch.server.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

@Entity
@Table(name = "slots")
data class Slot(
    @Id @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id", nullable = false)
    val field: Field,

    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,

    var isAvailable: Boolean = true
)
