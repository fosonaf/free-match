package com.freematch.server.domain.field.port

import com.freematch.server.domain.field.model.Field
import java.util.UUID

interface FieldPort {
    fun save(field: Field): Field
    fun findById(id: UUID): Field?
    fun findAll(): List<Field>
}