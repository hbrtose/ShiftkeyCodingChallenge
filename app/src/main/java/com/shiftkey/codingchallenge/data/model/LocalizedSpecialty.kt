package com.shiftkey.codingchallenge.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocalizedSpecialty(
    @Json(name = "abbreviation")
    val abbreviation: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "specialty")
    val specialty: Specialty,
    @Json(name = "specialty_id")
    val specialtyId: Int,
    @Json(name = "state_id")
    val stateId: Int
)