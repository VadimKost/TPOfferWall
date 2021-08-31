package com.v.tpofferwall.data.api

import com.v.tpofferwall.domain.model.Data
import com.v.tpofferwall.domain.model.DataItemInfo
import com.v.tpofferwall.domain.common.Result
import retrofit2.http.GET
import retrofit2.http.Path

interface OfferWallApi {
    @GET("entities/getAllIds")
    suspend fun getAllData():Result<Data>

    @GET("object/{id}")
    suspend fun getDataItemInfo(@Path("id") id:Int):Result<DataItemInfo>
}