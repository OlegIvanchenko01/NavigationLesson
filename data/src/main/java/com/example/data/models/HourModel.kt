package com.example.data.models

import com.google.gson.annotations.SerializedName

data class HourModel (
    @SerializedName("time") val time: String? = null,
    @SerializedName("temp_c") val tempC: Double? = null,
    @SerializedName("condition") val condition: ConditionModel,
){
    companion object{
        fun empty()=HourModel(
            "2024-10-22 00:00",
            11.2,
            ConditionModel.empty()
        )
    }
}