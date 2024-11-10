package com.example.data.repository

import android.database.CursorJoiner
import android.util.Log
import com.example.data.ApiService
import com.example.data.NetworkModule
import com.example.data.models.BreedsModel
import com.example.data.models.WeatherModel
import com.example.data.response.BreedsResponse


internal class BreedsRepository: BreedsRepositoryInterface {
    private val retrofit = NetworkModule.getApiService()
    override suspend fun getBreeds(id: String): Result<BreedsModel> {
        return Result.success(retrofit.getBreeds(id).toModel())
    }

    override suspend fun getWeather(city: String): Result<WeatherModel> {
        Log.d("MyLogs", "1: ${retrofit.getWeather(city).map{it.toModel()}}")
        return retrofit.getWeather(city).map{it.toModel()}
    }

}