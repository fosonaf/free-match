package com.freematch.server.adapter.web.field.dto

import com.freematch.server.domain.field.model.Field
import java.util.UUID

data class FieldResponse(
    val id: UUID,
    val name: String,
    val address: String,
    val city: String,
    val sports: List<String>,
    val latitude: Double,
    val longitude: Double
)

fun Field.toResponse() = FieldResponse(
    id = id,
    name = name,
    address = address,
    city = city,
    sports = sports,
    latitude = latitude,
    longitude = longitude
)