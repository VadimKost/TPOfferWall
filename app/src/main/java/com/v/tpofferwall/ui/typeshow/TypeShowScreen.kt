package com.v.tpofferwall.ui.typeshow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.vbook.presentation.common.UiState
import com.example.vbook.presentation.common.components.StateSection
import com.v.tpofferwall.domain.common.SupportedTypes
import com.v.tpofferwall.domain.model.DataItemInfo
import com.v.tpofferwall.ui.common.components.WebView

@Composable
fun TypeShowScreen(vm:TypeShowVM) {
    val state = vm.data.collectAsState()
    TypeShowBody(state.value,vm::getItem)
}

@Composable
fun TypeShowBody(
    state:UiState<DataItemInfo>,
    onClick:()->Unit={}
) {
    StateSection(state = state) {
        Box(Modifier.fillMaxSize()) {
            when(it.type){
                SupportedTypes.TEXT->{
                    Text(text = it.message!!)
                }
                SupportedTypes.IMAGE ->{
                    Image(
                        painter = rememberImagePainter(
                            data=it.url,
                            builder = {
                                crossfade(true)
                            },
                        ),
                        contentScale= ContentScale.FillWidth,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(140.dp)
                    )
                }
                SupportedTypes.WEBVIEW ->{
                    WebView(url = it.url!!)
                }
            }
            Button(onClick = onClick) {
                Text(text = "далее")
            }
        }
    }
}