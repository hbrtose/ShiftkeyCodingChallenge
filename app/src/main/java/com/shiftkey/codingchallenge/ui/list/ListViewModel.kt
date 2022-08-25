package com.shiftkey.codingchallenge.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiftkey.codingchallenge.domain.model.ShiftDto
import com.shiftkey.codingchallenge.domain.usecase.GetShiftsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import org.joda.time.DateTimeConstants
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getShiftsUseCase: GetShiftsUseCase) : ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _shifts = MutableLiveData<List<ShiftDto>>()
    val shifts: LiveData<List<ShiftDto>> = _shifts

    private var searchDate: Date? = null

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        update()
    }

    fun update() {
        val startDate = if (searchDate == null) {
            Date()
        } else {
            DateTime(searchDate).plusDays(1).withTimeAtStartOfDay().toDate()
        }
        searchDate = DateTime(startDate).withDayOfWeek(DateTimeConstants.SUNDAY).withTime(23, 59, 59, 0).toDate()
        viewModelScope.launch(exceptionHandler) {
            _loading.value = true
            getShiftsUseCase.getShifts(type = TYPE, start = startDate, end = searchDate!!, address = PLACE).also {
                _loading.value = false
                _shifts.value = it
            }
        }
    }
}

private const val TYPE = "week"
private const val PLACE = "Dallas,TX"