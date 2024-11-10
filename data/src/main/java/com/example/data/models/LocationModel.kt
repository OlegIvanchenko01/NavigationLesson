package com.example.data.models

data class LocationModel(
    val name : String?=null,
    val region: String?=null,
    val country: String?=null,
    val lat: Double?=null,
    val lon: Double?=null,
    val tzId: String?=null,
    val localtimeEpoch: Int?=null,
    val localtime: String?=null
){
    companion object{
        fun empty() = LocationModel(
            "London",
            "",
            "",
            0.0,
            0.0,
            "",
            0,
            ""
        )
    }
}