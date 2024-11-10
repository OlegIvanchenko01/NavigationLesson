package com.example.data.models

data class ForecastdayModel(
    val date: String? = null,
    val day: DayModel,
    val hour: List<HourModel>
){
    companion object{
        fun empty() = ForecastdayModel(
            "2024-10-22",
            DayModel.empty(),
            listOf(HourModel.empty())
        )
    }
}