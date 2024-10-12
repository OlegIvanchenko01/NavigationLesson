package com.example.navigationlesson.model

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("breed"   ) var breed   : String? = null,
  @SerializedName("country" ) var country : String? = null,
  @SerializedName("origin"  ) var origin  : String? = null,
  @SerializedName("coat"    ) var coat    : String? = null,
  @SerializedName("pattern" ) var pattern : String? = null

)