package com.example.navigationlesson.network

import com.example.navigationlesson.model.ExampleJson2KtKotlin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://catfact.ninja"



interface WeatherApiService {
    @GET("breeds")
    suspend fun getPhotos(@Query("page") page:String): Result<ExampleJson2KtKotlin>
}

object WeatherApi {
    val retrofitService : WeatherApiService by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        retrofit.create(WeatherApiService::class.java)
    }
}