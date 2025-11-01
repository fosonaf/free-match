package com.freematch.server.dto

import com.freematch.server.model.Player

fun Player.toResponse(): PlayerResponse = PlayerResponse(
    id = this.id,
    username = this.username,
    age = this.age
)