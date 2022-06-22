package com.example.myprojectapp.data.di

import com.example.myprojectapp.data.api.news.NewsAuthInterceptor
import com.example.myprojectapp.data.api.weather.WeatherAPI
import com.example.myprojectapp.data.api.weather.WeatherAuthInterceptor
import com.example.myprojectapp.data.constants.Constants
import com.example.myprojectapp.data.constants.Constants.Companion.BASE_URL_WEATHER
import com.example.myprojectapp.data.constants.Constants.Companion.WEATHER_API_KEY_1
import okhttp3.OkHttpClient
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal val weatherNetworkModule = module {

    single(qualifier("weather_api")) {

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(WeatherAuthInterceptor(""))
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    single {
        get<Retrofit>(qualifier("weather_api")).create<WeatherAPI>()
    }

}