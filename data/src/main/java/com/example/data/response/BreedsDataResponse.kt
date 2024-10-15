package com.example.data.response

import com.example.data.models.BreedsDataModel
import com.google.gson.annotations.SerializedName

internal data class BreedsDataResponse(
    @SerializedName("breed") val breed: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("origin") val origin: String? = null,
    @SerializedName("coat") val coat: String? = null,
    @SerializedName("pattern") val pattern: String? = null
) {
    fun toModel() = BreedsDataModel(
        breed,
        country,
        origin,
        coat,
        pattern
    )
}