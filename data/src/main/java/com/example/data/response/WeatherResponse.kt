package com.example.data.response

import com.example.data.models.WeatherModel
import com.google.gson.annotations.SerializedName

internal data class WeatherResponse(
    @SerializedName("location")val location : LocationResponse,
    @SerializedName("current")val current : CurrentResponse,
    @SerializedName("forecast")val forecast : ForecastResponse,
){
    fun toModel() = WeatherModel(
        location.toModel(),
        current.toModel(),
        forecast.toModel()
    )
}