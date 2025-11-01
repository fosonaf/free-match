package com.freematch.server.domain.user.port

import com.freematch.server.domain.user.model.User

interface UserPort {
    fun findByEmail(email: String): User?
    fun save(user: User): User
}