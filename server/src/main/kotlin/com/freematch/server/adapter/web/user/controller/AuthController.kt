package com.freematch.server.adapter.web.user.controller

import com.freematch.server.adapter.web.user.dto.*
import com.freematch.server.application.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/register")
    fun register(@RequestBody req: RegisterRequest): ResponseEntity<AuthResponse> {
        val token = authService.register(req.email, req.password, req.username)
        val user = authService.getUserByEmail(req.email)!!
        return ResponseEntity.ok(AuthResponse(token, user.id.toString(), user.username, user.email))
    }

    @PostMapping("/login")
    fun login(@RequestBody req: LoginRequest): ResponseEntity<AuthResponse> {
        val token = authService.login(req.email, req.password) ?: return ResponseEntity.status(401).build()
        val user = authService.getUserByEmail(req.email)!!
        return ResponseEntity.ok(AuthResponse(token, user.id.toString(), user.username, user.email))
    }
}