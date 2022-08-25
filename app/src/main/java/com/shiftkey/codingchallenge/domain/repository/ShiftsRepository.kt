package com.shiftkey.codingchallenge.domain.repository

import com.shiftkey.codingchallenge.domain.model.ShiftDto
import java.util.Date

interface ShiftsRepository {
    suspend fun getShifts(type: String, start: Date, end: Date, address: String): List<ShiftDto>
}