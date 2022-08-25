package com.shiftkey.codingchallenge.domain.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class ShiftDto(
    val covid: Boolean,
    val endTime: Date,
    val facilityType: String,
    val localizedSpecialty: String,
    val normalizedEndDateTime: String,
    val normalizedStartDateTime: String,
    val premiumRate: Boolean,
    val shiftId: Int,
    val shiftKind: String,
    val skill: String,
    val startTime: Date,
    val timezone: String,
    val withinDistance: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        Date(parcel.readLong()),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        Date(parcel.readLong()),
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (covid) 1 else 0)
        parcel.writeLong(endTime.time)
        parcel.writeString(facilityType)
        parcel.writeString(localizedSpecialty)
        parcel.writeString(normalizedEndDateTime)
        parcel.writeString(normalizedStartDateTime)
        parcel.writeByte(if (premiumRate) 1 else 0)
        parcel.writeInt(shiftId)
        parcel.writeString(shiftKind)
        parcel.writeString(skill)
        parcel.writeLong(startTime.time)
        parcel.writeString(timezone)
        parcel.writeInt(withinDistance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShiftDto> {
        override fun createFromParcel(parcel: Parcel): ShiftDto {
            return ShiftDto(parcel)
        }

        override fun newArray(size: Int): Array<ShiftDto?> {
            return arrayOfNulls(size)
        }
    }
}
