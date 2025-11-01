package com.freematch.server.adapter.web.field

import com.freematch.server.adapter.web.field.dto.FieldResponse
import com.freematch.server.domain.field.model.toResponse
import com.freematch.server.application.FieldService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/fields")
class FieldController(
    private val fieldService: FieldService
) {

    @GetMapping
    fun getAllFields(): List<FieldResponse> =
        fieldService.getAllFields().map { it.toResponse() }

    @GetMapping("/{id}")
    fun getField(@PathVariable id: UUID): ResponseEntity<FieldResponse> =
        fieldService.getField(id)
            ?.let { ResponseEntity.ok(it.toResponse()) }
            ?: ResponseEntity.notFound().build()
}