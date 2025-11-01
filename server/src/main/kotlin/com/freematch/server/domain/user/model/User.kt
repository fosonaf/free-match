package com.freematch.server.domain.user.model

import java.util.UUID

data class User(
    val id: UUID = UUID.randomUUID(),
    val email: String,
    val password: String, // hashed
    val username: String,
    val role: String = "USER"
)