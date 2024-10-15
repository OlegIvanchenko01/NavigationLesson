package com.example.data.repository

import com.example.data.models.BreedsModel
import com.example.data.response.BreedsResponse
import retrofit2.http.GET

interface BreedsRepositoryInterface {
    suspend fun getBreeds(id: String) : Result<BreedsModel>
    companion object{
        fun getInterface() =
    }
}