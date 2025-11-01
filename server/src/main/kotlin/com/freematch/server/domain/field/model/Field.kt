package com.freematch.server.domain.field.model

import com.freematch.server.adapter.web.field.dto.FieldResponse
import java.util.UUID

data class Field(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val address: String,
    val city: String,
    val sports: List<String>,
    val latitude: Double,
    val longitude: Double
)

fun Field.toResponse(): FieldResponse = FieldResponse(
    id = id,
    name = name,
    address = address,
    city = city,
    sports = sports,
    latitude = latitude,
    longitude = longitude
)