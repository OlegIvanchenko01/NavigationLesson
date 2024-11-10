package com.example.data.models

data class ConditionModel(
    val text: String? = null,
    val icon: String? = null,
    val code: Int? = null
){


    companion object{
        fun empty() = ConditionModel(
            "Partly cloudy",
            "//cdn.weatherapi.com/weather/64x64/day/116.png",
            0)
    }
}