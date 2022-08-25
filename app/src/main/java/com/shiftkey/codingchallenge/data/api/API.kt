package com.shiftkey.codingchallenge.data.api

import com.shiftkey.codingchallenge.data.model.ShiftsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface API {

    @GET("available_shifts")
    suspend fun getShifts(
        @Query("type") type: String,
        @Query("start") start: String,
        @Query("end") end: String,
        @Query("address") address: String
    ): ShiftsResponse
}