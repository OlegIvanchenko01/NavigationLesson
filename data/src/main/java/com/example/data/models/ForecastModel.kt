package com.example.data.models

data class ForecastModel (
    val forecastday : List<ForecastdayModel>
){
    companion object{
        fun empty() = ForecastModel(
            listOf(ForecastdayModel.empty())
        )
    }
}