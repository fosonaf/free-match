package com.freematch.server.adapter.web.user.dto

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    val email: String,
    val password: String,
    val username: String
)

data class AuthResponse(
    val token: String,
    val userId: String,
    val username: String,
    val email: String
)