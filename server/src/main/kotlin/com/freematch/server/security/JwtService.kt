package com.freematch.server.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date
import java.util.UUID
import javax.crypto.SecretKey

@Component
class JwtService {
    private val secret = "your-very-secure-secret-key-change-in-production-32chars"
    private val secretKey: SecretKey = Keys.hmacShaKeyFor(secret.toByteArray())
    private val expirationMs = 86400000L // 24h

    fun generateToken(userId: UUID, email: String, role: String): String {
        return Jwts.builder()
            .subject(userId.toString())
            .claim("email", email)
            .claim("role", role)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expirationMs))
            .signWith(secretKey)
            .compact()
    }

    fun extractUserId(token: String): UUID {
        val claims = Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
        return UUID.fromString(claims.subject)
    }

    fun isTokenValid(token: String): Boolean = try {
        Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
        true
    } catch (e: Exception) {
        false
    }
}