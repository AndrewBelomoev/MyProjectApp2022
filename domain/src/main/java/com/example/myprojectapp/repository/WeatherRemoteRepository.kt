package com.example.myprojectapp.repository

import com.example.myprojectapp.model.weather.WeatherResponse

interface WeatherRemoteRepository {

    suspend fun getCurrentWeather(location: String): Result<WeatherResponse>

}

// 6106860a27307e1459f7abf566c3c264