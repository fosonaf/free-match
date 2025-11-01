package com.freematch.server.repository

import com.freematch.server.model.Field
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FieldRepository : JpaRepository<Field, UUID>
