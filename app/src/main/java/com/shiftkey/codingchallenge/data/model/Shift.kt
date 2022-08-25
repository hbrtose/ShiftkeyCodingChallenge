package com.shiftkey.codingchallenge.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Shift(
    @Json(name = "covid")
    val covid: Boolean,
    @Json(name = "end_time")
    val endTime: Date,
    @Json(name = "facility_type")
    val facilityType: FacilityType,
    @Json(name = "localized_specialty")
    val localizedSpecialty: LocalizedSpecialty,
    @Json(name = "normalized_end_date_time")
    val normalizedEndDateTime: String,
    @Json(name = "normalized_start_date_time")
    val normalizedStartDateTime: String,
    @Json(name = "premium_rate")
    val premiumRate: Boolean,
    @Json(name = "shift_id")
    val shiftId: Int,
    @Json(name = "shift_kind")
    val shiftKind: String,
    @Json(name = "skill")
    val skill: Skill,
    @Json(name = "start_time")
    val startTime: Date,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "within_distance")
    val withinDistance: Int
)