package com.example.data.repository

import com.example.data.models.BreedsModel
import com.example.data.models.WeatherModel
import retrofit2.Response


interface BreedsRepositoryInterface {
    suspend fun getBreeds(id: String) : Result<BreedsModel>
    suspend fun getWeather(city: String) : Result<WeatherModel>
}