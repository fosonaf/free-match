package com.freematch.server.controller

import com.freematch.server.model.Field
import com.freematch.server.repository.FieldRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/fields")
class FieldController(
    private val fieldRepository: FieldRepository
) {

    @GetMapping
    fun getAll(
        @RequestParam city: String?,
        @RequestParam sport: String?
    ): List<Field> {
        val fields = fieldRepository.findAll()

        return when {
            city != null && sport != null -> fields.filter {
                it.city.equals(city, ignoreCase = true) &&
                        it.sports.contains(sport.uppercase())
            }
            city != null -> fields.filter { it.city.equals(city, ignoreCase = true) }
            sport != null -> fields.filter { it.sports.contains(sport.uppercase()) }
            else -> fields
        }
    }

    @GetMapping("/{id}/slots")
    fun getSlots(@PathVariable id: UUID): List<Any> {
        return listOf("Coming soon")
    }
}
