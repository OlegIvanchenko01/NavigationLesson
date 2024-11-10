package com.example.data.response

import com.example.data.models.ConditionModel
import com.google.gson.annotations.SerializedName

internal data class ConditionResponse(
    @SerializedName("text") val text: String? = null,
    @SerializedName("icon") val icon: String? = null,
    @SerializedName("code") val code: Int? = null
) {
    fun toModel() = ConditionModel(
        text,
        icon,
        code
    )
}