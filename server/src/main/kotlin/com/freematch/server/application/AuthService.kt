package com.freematch.server.application

import com.freematch.server.domain.user.model.User
import com.freematch.server.domain.user.port.UserPort
import com.freematch.server.security.JwtService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AuthService(
    private val userPort: UserPort,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService
) {
    fun register(email: String, password: String, username: String): String {
        val hashed = passwordEncoder.encode(password)
        val user = User(email = email, password = hashed, username = username)
        userPort.save(user)
        return jwtService.generateToken(user.id, user.email, user.role)
    }

    fun login(email: String, password: String): String? {
        val user = userPort.findByEmail(email) ?: return null
        return if (passwordEncoder.matches(password, user.password)) {
            jwtService.generateToken(user.id, user.email, user.role)
        } else null
    }

    fun getUserByEmail(email: String): User? {
        return userPort.findByEmail(email)
    }
}