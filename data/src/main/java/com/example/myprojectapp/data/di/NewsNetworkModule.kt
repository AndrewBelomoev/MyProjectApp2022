package com.example.myprojectapp.data.di

import com.example.myprojectapp.data.api.news.NewsAuthInterceptor
import com.example.myprojectapp.data.api.news.NewsAPI
import com.example.myprojectapp.data.constants.Constants.Companion.API_KEY_3
import com.example.myprojectapp.data.constants.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal val networkModule = module {

    single() {
        OkHttpClient
            .Builder()
            .build()
    }

    single(qualifier("news_api")) {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(NewsAuthInterceptor(API_KEY_3))
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    single {
        get<Retrofit>(qualifier("news_api")).create<NewsAPI>()
    }

}
