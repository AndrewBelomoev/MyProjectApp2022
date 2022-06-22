package com.example.myprojectapp.data.repository

import com.example.myprojectapp.data.api.weather.WeatherAPI
import com.example.myprojectapp.data.mapper.toDomainModel
import com.example.myprojectapp.model.weather.WeatherResponse
import com.example.myprojectapp.repository.WeatherRemoteRepository

class WeatherRemoteRepositoryImpl(private val api: WeatherAPI) : WeatherRemoteRepository {

    override suspend fun getCurrentWeather(location: String) = runCatching {
        api.getCurrentWeather(location = location)
    }.map { weatherResponseDTO ->
        weatherResponseDTO.toDomainModel()
    }

}