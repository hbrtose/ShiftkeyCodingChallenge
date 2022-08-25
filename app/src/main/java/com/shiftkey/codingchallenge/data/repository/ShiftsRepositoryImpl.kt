package com.shiftkey.codingchallenge.data.repository

import com.shiftkey.codingchallenge.data.api.API
import com.shiftkey.codingchallenge.data.model.ShiftsResponse
import com.shiftkey.codingchallenge.domain.common.Mapper
import com.shiftkey.codingchallenge.domain.model.ShiftDto
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import java.text.SimpleDateFormat
import java.util.*

class ShiftsRepositoryImpl(
    private val api: API,
    private val mapper: Mapper<ShiftsResponse, List<ShiftDto>>
) : ShiftsRepository {
    override suspend fun getShifts(type: String, start: Date, end: Date, address: String): List<ShiftDto> {
        return mapper.mapFrom(api.getShifts(type, start.format(), end.format(), address))
    }
}

fun Date.format(): String {
    val pattern = "yyyy-MM-dd"
    val simpleDateFormat = SimpleDateFormat(pattern)
    return simpleDateFormat.format(this)
}