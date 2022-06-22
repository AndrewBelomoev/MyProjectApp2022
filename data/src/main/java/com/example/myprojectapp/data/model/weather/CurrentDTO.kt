package com.example.myprojectapp.data.model.weather

import com.google.gson.annotations.SerializedName

data class CurrentDTO(
    @SerializedName("cloudcover")
    val cloudCover: Int? = null,
    @SerializedName("feelslike")
    val feelsLike: Int? = null,
    @SerializedName("humidity")
    val humidity: Int? = null,
    @SerializedName("is_day")
    val isDay: String? = null,
    @SerializedName("observation_time")
    val observationTime: String? = null,
    @SerializedName("precip")
    val precipitation: Double? = null,
    @SerializedName("pressure")
    val pressure: Int? = null,
    @SerializedName("temperature")
    val temperature: Int? = null,
    @SerializedName("uv_index")
    val uvIndex: Int? = null,
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("weather_code")
    val weatherCode: Int? = null,
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("wind_degree")
    val windDegree: Int? = null,
    @SerializedName("wind_dir")
    val windDir: String? = null,
    @SerializedName("wind_speed")
    val windSpeed: Int? = null
)