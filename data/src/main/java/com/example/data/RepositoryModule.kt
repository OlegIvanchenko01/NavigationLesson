package com.example.data

import com.example.data.models.BreedsModel
import com.example.data.repository.BreedsRepository
import com.example.data.repository.BreedsRepositoryInterface

class RepositoryModule {
    companion object {
        fun getInterface(): BreedsRepositoryInterface {
            return BreedsRepository()
        }
    }

}