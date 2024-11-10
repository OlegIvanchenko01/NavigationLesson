package com.example.data.response

import com.example.data.models.ForecastModel
import com.google.gson.annotations.SerializedName

internal data class ForecastResponse (
    @SerializedName("forecastday") val forecastday : List<ForecastdayResponse>
){
    fun toModel() = ForecastModel(
        forecastday.map {
            it.toModel()
        }
    )
}