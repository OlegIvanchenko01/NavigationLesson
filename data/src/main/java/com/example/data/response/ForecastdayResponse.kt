package com.example.data.response

import com.example.data.models.DayModel
import com.example.data.models.ForecastdayModel
import com.google.gson.annotations.SerializedName

internal data class ForecastdayResponse (
    @SerializedName("date") val date : String? = null,
    @SerializedName("day") val day : DayResponse,
    @SerializedName("hour") val hour : List<HourResponse>
){
    fun toModel() = ForecastdayModel(
        date,
        day.toModel(),
        hour.map {
            it.toModel()
        }
    )
}