package com.example.data.models



data class CurrentModel(
    val lastUpdatedEpoch: Int?=null,
    val lastUpdated: String?=null,
    val tempC: Double?=null,
    val tempF: Double?=null,
    val isDay: Int?=null,
    val condition: ConditionModel,
    val windKph : Double? = null,
    val precipMm : Double? = null
){
    companion object{
        fun empty() = CurrentModel(
            0,
            "2024-10-22 17:00",
            14.4,
            0.0,
            0,
            ConditionModel.empty(),
            10.1,
            0.02
        )
    }
}