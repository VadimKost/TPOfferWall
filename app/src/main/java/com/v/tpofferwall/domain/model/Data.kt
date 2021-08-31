package com.v.tpofferwall.domain.model

import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("id") val id : Int
)
data class Data(
    @SerializedName("data") val data : List<DataItem>
)
