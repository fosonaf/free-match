package com.freematch.server.adapter.web.player.dto

import com.freematch.server.domain.player.model.Player


fun Player.toResponse(): PlayerResponse = PlayerResponse(
    id = this.id,
    username = this.username,
    age = this.age
)