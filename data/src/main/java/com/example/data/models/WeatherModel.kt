package com.example.data.models

data class WeatherModel(
    val location : LocationModel,
    val current : CurrentModel,
    val forecast : ForecastModel,

){
    companion object{
        fun empty() = WeatherModel(
            LocationModel.empty(),
            CurrentModel.empty(),
            ForecastModel.empty()
        )
    }
}