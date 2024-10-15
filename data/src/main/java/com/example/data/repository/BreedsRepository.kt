package com.example.data.repository

import com.example.data.ApiService
import com.example.data.NetworkModule
import com.example.data.models.BreedsModel
import com.example.data.response.BreedsResponse

internal class BreedsRepository: BreedsRepositoryInterface {
    private val retrofit = NetworkModule.getApiService()
    override suspend fun getBreeds(id: String): Result<BreedsModel> {
        return retrofit.getBreeds(id).map {
            it.toModel()
        }
    }

}