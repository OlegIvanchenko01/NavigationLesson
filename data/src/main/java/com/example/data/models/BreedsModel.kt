package com.example.data.models


data class BreedsModel(
    val data: List<BreedsDataModel>
){
    companion object{
        fun empty() = BreedsModel(listOf(BreedsDataModel.empty()))
    }
}
