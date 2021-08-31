package com.v.tpofferwall.data.repositoty

import com.v.tpofferwall.data.api.OfferWallApi
import com.v.tpofferwall.domain.DataRepository
import com.v.tpofferwall.domain.model.Data
import com.v.tpofferwall.domain.model.DataItemInfo
import javax.inject.Inject
import javax.inject.Singleton
import com.v.tpofferwall.domain.common.Result

@Singleton
class DataRepositoryImpl @Inject constructor(
    val offerWallApi: OfferWallApi
): DataRepository {

    override suspend fun getAllData():Result<Data> = offerWallApi.getAllData()

    override suspend fun getDataItemInfo(id:Int):Result<DataItemInfo> =offerWallApi.getDataItemInfo(id)
}