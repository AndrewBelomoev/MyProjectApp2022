package com.example.myprojectapp.data.model.weather

data class WeatherResponseDTO(
    val current: CurrentDTO? = null,
    val location: LocationDTO? = null,
    val request: RequestDTO? = null
)