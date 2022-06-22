package com.example.myprojectapp.model.weather

data class WeatherResponse(
    val current: Current? = null,
    val location: Location? = null,
    val request: Request? = null
)