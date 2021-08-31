package com.v.tpofferwall.domain.model

import com.google.gson.annotations.SerializedName

data class DataItemInfo(
    @SerializedName("id") var id : Int,
    @SerializedName("type") var type : String,
    @SerializedName("message") var message : String?,
    @SerializedName("url") var url:String?,
)