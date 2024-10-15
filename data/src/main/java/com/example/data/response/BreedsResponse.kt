package com.example.data.response

import com.example.data.models.BreedsDataModel
import com.example.data.models.BreedsModel
import com.google.gson.annotations.SerializedName

internal data class BreedsResponse(
    @SerializedName("data") val data: List<BreedsDataResponse>
) {
    fun toModel() = BreedsModel(
        data.map {
            it.toModel()
        }
    )
}

