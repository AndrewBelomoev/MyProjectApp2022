package com.example.myprojectapp.usecase

import com.example.myprojectapp.model.weather.WeatherResponse
import com.example.myprojectapp.repository.WeatherRemoteRepository

class GetCurrentWeatherUseCase(private val repository: WeatherRemoteRepository) {

    suspend operator fun invoke(location: String): Result<WeatherResponse> {
        return repository.getCurrentWeather(location = location)
    }

}