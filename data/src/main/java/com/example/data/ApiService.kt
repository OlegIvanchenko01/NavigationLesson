package com.example.data

import com.example.data.models.BreedsDataModel
import com.example.data.response.BreedsDataResponse
import com.example.data.response.BreedsResponse
import com.example.data.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {
    @GET("breeds")
    suspend fun getBreeds(@Query("page") page: String): BreedsResponse

    @GET("/v1/forecast.json?key=6ca4b6c2d5a641f49e3110320241609&days=3&aqi=no&alerts=no&lang=ru")
    suspend fun getWeather(@Query("q") city : String): Result<WeatherResponse>

}