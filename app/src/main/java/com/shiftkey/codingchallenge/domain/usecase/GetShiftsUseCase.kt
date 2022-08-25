package com.shiftkey.codingchallenge.domain.usecase

import com.shiftkey.codingchallenge.domain.common.UseCase
import com.shiftkey.codingchallenge.domain.model.ShiftDto
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import java.lang.IllegalArgumentException
import java.util.Date

class GetShiftsUseCase(private val repository: ShiftsRepository) : UseCase<GetShiftsUseCase.ShiftParams, List<ShiftDto>>() {

    suspend fun getShifts(type: String, start: Date, end: Date, address: String): List<ShiftDto> {
        return observable(ShiftParams(type, start, end, address))
    }

    override suspend fun createObservable(data: ShiftParams?): List<ShiftDto> {
        data?.let {
            return repository.getShifts(it.type, it.start, it.end, it.address)
        } ?: throw IllegalArgumentException("No data provided")
    }

    data class ShiftParams(
        val type: String,
        val start: Date,
        val end: Date,
        val address: String
    )
}