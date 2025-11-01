package com.freematch.server.adapter.persistence.user

import com.freematch.server.domain.user.model.User
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users")
data class JpaUserEntity(
    @Id val id: UUID = UUID.randomUUID(),
    @Column(unique = true, nullable = false) val email: String,
    @Column(nullable = false) val password: String,
    @Column(nullable = false) val username: String,
    val role: String = "USER"
)

fun JpaUserEntity.toDomain() = User(id, email, password, username, role)
fun User.toEntity() = JpaUserEntity(id, email, password, username, role)