package com.freematch.server.adapter.persistence.field

import com.freematch.server.domain.field.model.Field
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "fields")
data class JpaFieldEntity(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    val city: String,

    @ElementCollection
    @CollectionTable(name = "field_sports", joinColumns = [JoinColumn(name = "field_id")])
    @Column(name = "sport")
    val sports: List<String>,

    val latitude: Double,
    val longitude: Double
)

fun JpaFieldEntity.toDomain() = Field(
    id = id,
    name = name,
    address = address,
    city = city,
    sports = sports,
    latitude = latitude,
    longitude = longitude
)

fun Field.toEntity() = JpaFieldEntity(
    id = id,
    name = name,
    address = address,
    city = city,
    sports = sports,
    latitude = latitude,
    longitude = longitude
)