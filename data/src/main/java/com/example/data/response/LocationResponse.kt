package com.example.data.response

import com.example.data.models.LocationModel
import com.google.gson.annotations.SerializedName

internal data class LocationResponse(
    @SerializedName("name")val name : String? = null,
    @SerializedName("region")val region: String? = null,
    @SerializedName("country")val country: String? = null,
    @SerializedName("lat")val lat: Double? = null,
    @SerializedName("lon")val lon: Double? = null,
    @SerializedName("tz_id")val tzId: String? = null,
    @SerializedName("localtime_epoch")val localtimeEpoch: Int? = null,
    @SerializedName("localtime")val localtime: String? = null
){
    fun toModel() = LocationModel(
        name,
        region,
        country,
        lat,
        lon,
        tzId,
        localtimeEpoch,
        localtime
    )
}