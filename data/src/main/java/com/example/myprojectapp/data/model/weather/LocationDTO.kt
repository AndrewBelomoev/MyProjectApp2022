package com.example.myprojectapp.data.model.weather

import com.google.gson.annotations.SerializedName

data class LocationDTO(
    val country: String? = null,
    val lat: String? = null,
    val localtime: String? = null,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int? = null,
    val lon: String? = null,
    val name: String? = null,
    val region: String? = null,
    @SerializedName("timezone_id")
    val timezoneId: String? = null,
    @SerializedName("utc_offset")
    val utcOffset: String? = null
)