package com.example.myprojectapp.model.weather

data class Current(
    val cloudCover: Int? = null,
    val feelsLike: Int? = null,
    val humidity: Int? = null,
    val isDay: String? = null,
    val observationTime: String? = null,
    val precipitation: Double? = null,
    val pressure: Int? = null,
    val temperature: Int? = null,
    val uvIndex: Int? = null,
    val visibility: Int? = null,
    val weatherCode: Int? = null,
    val weatherDescriptions: List<String>,
    val weatherIcons: List<String>,
    val windDegree: Int? = null,
    val windDir: String? = null,
    val windSpeed: Int? = null
)