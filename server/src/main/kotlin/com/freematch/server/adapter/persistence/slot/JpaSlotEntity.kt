package com.freematch.server.adapter.persistence.slot

import com.freematch.server.adapter.persistence.field.JpaFieldEntity
import com.freematch.server.domain.slot.model.Slot
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

@Entity
@Table(name = "slots")
data class JpaSlotEntity(
    @Id @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    @ManyToOne
    @JoinColumn(name = "field_id")
    val field: JpaFieldEntity,

    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val isAvailable: Boolean
)

fun JpaSlotEntity.toDomain() = Slot(
    id = id,
    fieldId = field.id,
    date = date,
    startTime = startTime,
    endTime = endTime,
    isAvailable = isAvailable
)

fun Slot.toEntity(field: JpaFieldEntity) = JpaSlotEntity(
    id = id,
    field = field,
    date = date,
    startTime = startTime,
    endTime = endTime,
    isAvailable = isAvailable
)