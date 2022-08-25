package com.shiftkey.codingchallenge.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShiftsResponse(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "links")
    val links: List<Any>,
    @Json(name = "meta")
    val meta: Meta
)