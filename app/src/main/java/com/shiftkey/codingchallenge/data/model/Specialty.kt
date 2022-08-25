package com.shiftkey.codingchallenge.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Specialty(
    @Json(name = "abbreviation")
    val abbreviation: String,
    @Json(name = "color")
    val color: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)