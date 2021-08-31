package com.v.tpofferwall.ui.typeshow

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vbook.presentation.common.UiState
import com.v.tpofferwall.domain.DataRepository
import com.v.tpofferwall.domain.common.Result
import com.v.tpofferwall.domain.common.SupportedTypes
import com.v.tpofferwall.domain.model.Data
import com.v.tpofferwall.domain.model.DataItem
import com.v.tpofferwall.domain.model.DataItemInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TypeShowVM @Inject constructor(
    val dataRepository: DataRepository
): ViewModel() {
    init {
        Log.e("V","Create")
    }
    private val _data = MutableStateFlow<UiState<DataItemInfo>>(UiState.Loading)
    val data = _data.asStateFlow()

    var idsList = listOf<DataItem>()

    var currentIndex = 0
    suspend fun initGetItem(){
        getInitList()
        getItem()
    }

    suspend fun getInitList(){
        withContext(IO){
            val initList:Result<Data> = dataRepository.getAllData()
            when(initList){
                is Result.Success ->{
                    idsList=initList.data.data
                }
                is Result.Error -> {
                    _data.value = UiState.Error(initList.message)
                }
            }
        }
    }

    fun getItem(){
        viewModelScope.launch {
            if (idsList.size-1 < currentIndex){
                currentIndex=0
            }
            Log.e("Vid",idsList.toString())
            val dataItemInfo =dataRepository.getDataItemInfo(idsList[currentIndex].id)
            when(dataItemInfo){
                is Result.Success ->{
                    if (dataItemInfo.data.type in SupportedTypes.types){
                        Log.e("Vitem",dataItemInfo.data.toString())
                        Log.e("Vindex",currentIndex.toString())
                        _data.value =UiState.Success(dataItemInfo.data)
                        currentIndex+=1
                    }else{
                        currentIndex+=1
                        getItem()
                    }
                }
                is Result.Error -> {
                    _data.value = UiState.Error(dataItemInfo.message)
                }
            }
        }
    }
}