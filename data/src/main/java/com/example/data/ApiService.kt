package com.example.data

import com.example.data.models.BreedsDataModel
import com.example.data.response.BreedsDataResponse
import com.example.data.response.BreedsResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {
    @GET("breeds")
    suspend fun getBreeds(@Query("page") page: String): Result<BreedsResponse>
}