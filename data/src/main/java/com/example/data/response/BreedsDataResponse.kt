package com.example.data.response

import com.example.data.models.BreedsDataModel
import com.google.gson.annotations.SerializedName

internal data class BreedsDataResponse(
    @SerializedName("breed") val breed: String = "",
    @SerializedName("country") val country: String = "",
    @SerializedName("origin") val origin: String = "",
    @SerializedName("coat") val coat: String = "",
    @SerializedName("pattern") val pattern: String = ""
) {
    fun toModel() = BreedsDataModel(
        breed,
        country,
        origin,
        coat,
        pattern
    )
}