package com.example.data.response

import com.example.data.models.DayModel
import com.google.gson.annotations.SerializedName

internal data class DayResponse (
    @SerializedName("maxtemp_c") val maxtempC : Double? = null,
    @SerializedName("mintemp_c") val mintempC : Double? = null,
    @SerializedName("condition") val condition : ConditionResponse,
){
    fun toModel() = DayModel(
        maxtempC,
        mintempC,
        condition.toModel()
    )
}