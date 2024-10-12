package com.example.navigationlesson.model

import com.google.gson.annotations.SerializedName

data class ExampleJson2KtKotlinModel(
    var currentPage: Int,
    var data: List<Data>,
    var firstPageUrl: String,
    var from: Int,
    var lastPage: Int,
    var lastPageUrl: String,
    var links: List<Links>,
    var nextPageUrl: String,
    var path: String,
    var perPage: Int,
    var prevPageUrl: String,
    var to: Int,
    var total: Int
) {
    companion object {
        fun empty() = ExampleJson2KtKotlinModel(
            1,
            listOf(Data("", "", "", "", "")),
            "",
            1,
            1,
            "",
            listOf(Links("", "", null)),
            "",
            "",
            0,
            "",
            0,
            0
        )
    }
}


data class ExampleJson2KtKotlin(
    @SerializedName("current_page") var currentPage: Int? = null,
    @SerializedName("data") var data: List<Data> = listOf(),
    @SerializedName("first_page_url") var firstPageUrl: String? = null,
    @SerializedName("from") var from: Int? = null,
    @SerializedName("last_page") var lastPage: Int? = null,
    @SerializedName("last_page_url") var lastPageUrl: String? = null,
    @SerializedName("links") var links: List<Links> = listOf(),
    @SerializedName("next_page_url") var nextPageUrl: String? = null,
    @SerializedName("path") var path: String? = null,
    @SerializedName("per_page") var perPage: Int? = null,
    @SerializedName("prev_page_url") var prevPageUrl: String? = null,
    @SerializedName("to") var to: Int? = null,
    @SerializedName("total") var total: Int? = null
) {
    fun toModels() = ExampleJson2KtKotlinModel(
        currentPage ?: 0,
        data.map {
            it.copy(
                country = if (it.country == "Russian") it.country else "${it.country}/xui"
            )
        },
        firstPageUrl ?: "",
        from ?: 0,
        lastPage ?: 0,
        lastPageUrl ?: "",
        links,
        nextPageUrl ?: "",
        path ?: "",
        perPage ?: 0,
        prevPageUrl ?: "",
        to ?: 0,
        total ?: 0,
    )
}