package com.shiftkey.codingchallenge.data.mapper

import com.shiftkey.codingchallenge.data.model.ShiftsResponse
import com.shiftkey.codingchallenge.domain.common.Mapper
import com.shiftkey.codingchallenge.domain.model.ShiftDto

class ShiftResponseToShiftsMapper : Mapper<ShiftsResponse, List<ShiftDto>>() {
    override fun mapFrom(from: ShiftsResponse): List<ShiftDto> {
        return from.data.flatMap { data ->
            data.shifts.map { shift ->
                ShiftDto(shift.covid, shift.endTime, shift.facilityType.name, shift.localizedSpecialty.name, shift.normalizedEndDateTime,
                    shift.normalizedStartDateTime, shift.premiumRate, shift.shiftId, shift.shiftKind, shift.skill.name, shift.startTime,
                    shift.timezone, shift.withinDistance)
            }
        }
    }
}