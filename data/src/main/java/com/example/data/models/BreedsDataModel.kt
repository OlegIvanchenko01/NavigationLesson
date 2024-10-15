package com.example.data.models

import com.google.gson.annotations.SerializedName

data class BreedsDataModel(
    val breed: String? = null,
    val country: String? = null,
    val origin: String? = null,
    val coat: String? = null,
    val pattern: String? = null
) {
    companion object {
        fun empty() = BreedsDataModel(
            "",
            "",
            "",
            "",
            "")
    }
}