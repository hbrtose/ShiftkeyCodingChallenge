package com.shiftkey.codingchallenge.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "date")
    val date: String,
    @Json(name = "shifts")
    val shifts: List<Shift>
)