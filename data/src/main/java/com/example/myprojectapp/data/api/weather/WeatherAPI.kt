package com.example.myprojectapp.data.api.weather

import com.example.myprojectapp.data.model.weather.WeatherResponseDTO
import com.example.myprojectapp.model.weather.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("current")
    suspend fun getCurrentWeather(
        @Query("query")
        location: String,
//        @Query("language")
//        language: String = "ru",
        @Query("access_key")
        key: String = "6106860a27307e1459f7abf566c3c264"
    ): WeatherResponseDTO

//    @GET("/forecast")
//    suspend fun getWeatherForecast(  // For money
//        @Query("query")
//        location: String,
//        @Query("access_key")
//        key: String = "6106860a27307e1459f7abf566c3c264"
//    ): WeatherResponse

}