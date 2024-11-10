package com.example.data.models


data class BreedsModel(
    val data: List<BreedsDataModel> = listOf()
){
    companion object{
        fun empty() = BreedsModel(listOf(BreedsDataModel.empty()))
    }
}
