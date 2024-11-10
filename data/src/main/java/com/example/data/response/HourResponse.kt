package com.example.data.response

import com.example.data.models.HourModel
import com.google.gson.annotations.SerializedName

internal data class HourResponse (
    @SerializedName("time") val time: String? = null,
    @SerializedName("temp_c") val tempC: Double? = null,
    @SerializedName("condition") val condition: ConditionResponse,
){
    fun toModel() = HourModel(
        time,
        tempC,
        condition.toModel()
    )
}