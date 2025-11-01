package com.freematch.server.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "fields")
data class Field(
    @Id @GeneratedValue
    val id: UUID = UUID.randomUUID(),

    val name: String,
    val address: String,
    val city: String,

    @ElementCollection
    @CollectionTable(name = "field_sports", joinColumns = [JoinColumn(name = "field_id")])
    @Column(name = "sport")
    val sports: List<String> = emptyList(),

    val latitude: Double? = null,
    val longitude: Double? = null
)
