package com.freematch.server.adapter.persistence.user

import com.freematch.server.domain.user.model.User
import com.freematch.server.domain.user.port.UserPort
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(
    private val jpaRepo: JpaUserRepository
) : UserPort {
    override fun findByEmail(email: String): User? =
        jpaRepo.findByEmail(email)?.toDomain()

    override fun save(user: User): User =
        jpaRepo.save(user.toEntity()).toDomain()
}