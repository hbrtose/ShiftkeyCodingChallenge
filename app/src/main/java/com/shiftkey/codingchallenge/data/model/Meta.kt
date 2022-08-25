package com.shiftkey.codingchallenge.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lng")
    val lng: Double
)