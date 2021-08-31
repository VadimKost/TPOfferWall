package com.v.tpofferwall.domain

import com.v.tpofferwall.domain.model.Data
import com.v.tpofferwall.domain.model.DataItemInfo
import com.v.tpofferwall.domain.common.Result

interface DataRepository {
    suspend fun getAllData():Result<Data>

    suspend fun getDataItemInfo(id:Int):Result<DataItemInfo>
}