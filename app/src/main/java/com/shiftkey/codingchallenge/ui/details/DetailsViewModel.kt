package com.shiftkey.codingchallenge.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shiftkey.codingchallenge.domain.model.ShiftDto
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _shift = MutableLiveData<ShiftDto>()
    val shift: LiveData<ShiftDto> = _shift

    fun setDto(dto: ShiftDto) {
        _shift.value = dto
    }
}