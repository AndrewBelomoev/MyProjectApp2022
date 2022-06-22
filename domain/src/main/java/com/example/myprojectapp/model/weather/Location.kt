package com.example.myprojectapp.model.weather

data class Location(
    val country: String? = null,
    val lat: String? = null,
    val localtime: String? = null,
    val localtimeEpoch: Int? = null,
    val lon: String? = null,
    val name: String? = null,
    val region: String? = null,
    val timezoneId: String? = null,
    val utcOffset: String? = null
)