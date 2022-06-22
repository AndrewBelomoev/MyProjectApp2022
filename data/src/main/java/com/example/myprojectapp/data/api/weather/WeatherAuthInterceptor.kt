package com.example.myprojectapp.data.api.weather

import com.example.myprojectapp.data.constants.Constants
import com.example.myprojectapp.data.constants.Constants.Companion.WEATHER_API_KEY_1
import okhttp3.Interceptor
import okhttp3.Response



class WeatherAuthInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("key", WEATHER_API_KEY_1)
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }

}