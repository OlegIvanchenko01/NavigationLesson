package com.example.example

import com.google.gson.annotations.SerializedName

data class ExampleJson2KtKotlinModel(

  var currentPage  : Int             ,
  var data         : List<Data>  ,
  var firstPageUrl : String          ,
  var from         : Int             ,
  var lastPage     : Int             ,
  var lastPageUrl  : String          ,
  var links        : List<Links> ,
  var nextPageUrl  : String         ,
  var path         : String          ,
  var perPage      : Int             ,
  var prevPageUrl  : String          ,
  var to           : Int             ,
  var total        : Int

){
  companion object{
    fun empty() = ExampleJson2KtKotlinModel(
      1,
      listOf(),
      "",
      1,
      1,
      "",
      listOf(),
      "",
      "",
      0,
      "",
      0,
      0
    )
  }
}


data class ExampleJson2KtKotlin (

  @SerializedName("current_page"   ) var currentPage  : Int?             ,
  @SerializedName("data"           ) var data         : List<Data>       ,
  @SerializedName("first_page_url" ) var firstPageUrl : String?          ,
  @SerializedName("from"           ) var from         : Int?             ,
  @SerializedName("last_page"      ) var lastPage     : Int?             ,
  @SerializedName("last_page_url"  ) var lastPageUrl  : String?          ,
  @SerializedName("links"          ) var links        : List<Links> ,
  @SerializedName("next_page_url"  ) var nextPageUrl  : String?          ,
  @SerializedName("path"           ) var path         : String?          ,
  @SerializedName("per_page"       ) var perPage      : Int?             ,
  @SerializedName("prev_page_url"  ) var prevPageUrl  : String?          ,
  @SerializedName("to"             ) var to           : Int?             ,
  @SerializedName("total"          ) var total        : Int?

){
  fun toModels()=ExampleJson2KtKotlinModel(
    currentPage ?: 0,
    data.map{
      it.copy(
        country = if (it.country=="Russian") it.country else "${it.country}/xui"
      )
    },
    firstPageUrl?:"",
    from?:0,
    lastPage?:0,
    lastPageUrl?:"",
    links,
    nextPageUrl?:"",
    path?:"",
    perPage?:0,
    prevPageUrl?:"",
    to?:0,
    total?:0,
  )
}