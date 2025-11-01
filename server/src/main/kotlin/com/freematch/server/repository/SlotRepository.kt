package com.freematch.server.repository

import com.freematch.server.model.Slot
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SlotRepository : JpaRepository<Slot, UUID>
