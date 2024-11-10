package com.example.data

import com.example.data.Api.BASE_URL
import com.example.data.Api.BASE_URL_WEATHER
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class NetworkModule {
    companion object {
        fun getApiService(): ApiService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL_WEATHER)
                .build()
                .create(ApiService::class.java)

        }
    }
}

