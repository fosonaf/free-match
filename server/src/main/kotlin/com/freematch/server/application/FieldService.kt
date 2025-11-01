package com.freematch.server.application

import com.freematch.server.domain.field.model.Field
import com.freematch.server.domain.field.port.FieldPort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FieldService(
    private val fieldPort: FieldPort
) {
    fun getAllFields(): List<Field> = fieldPort.findAll()
    fun getField(id: UUID): Field? = fieldPort.findById(id)
}