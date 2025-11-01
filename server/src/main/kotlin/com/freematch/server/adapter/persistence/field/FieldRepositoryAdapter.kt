package com.freematch.server.adapter.persistence.field

import com.freematch.server.domain.field.model.Field
import com.freematch.server.domain.field.port.FieldPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FieldRepositoryAdapter(
    private val jpaRepo: JpaFieldRepository
) : FieldPort {

    override fun save(field: Field): Field =
        jpaRepo.save(field.toEntity()).toDomain()

    override fun findById(id: UUID): Field? =
        jpaRepo.findById(id).map { it.toDomain() }.orElse(null)

    override fun findAll(): List<Field> =
        jpaRepo.findAll().map { it.toDomain() }
}