package com.example.data.response

import com.example.data.models.CurrentModel
import com.google.gson.annotations.SerializedName


internal data class CurrentResponse(
    @SerializedName("last_updated_epoch")val lastUpdatedEpoch  :Int? = null,
    @SerializedName("last_updated")      val lastUpdated       :String? = null,
    @SerializedName("temp_c")            val tempC             :Double? = null,
    @SerializedName("temp_f")            val tempF             :Double? = null,
    @SerializedName("is_day")            val isDay             :Int? = null,
    @SerializedName("condition")         val condition         :ConditionResponse,
    @SerializedName("wind_kph")val windKph : Double? = null,
    @SerializedName("precip_mm")val precipMm : Double? = null
){
    fun toModel() = CurrentModel(
        lastUpdatedEpoch,
        lastUpdated,
        tempC,
        tempF,
        isDay,
        condition.toModel(),
        windKph,
        precipMm
    )
}