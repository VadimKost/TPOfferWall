package com.v.tpofferwall.ui.typeshow

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.vbook.presentation.common.UiState
import com.example.vbook.presentation.common.components.StateSection
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.v.tpofferwall.domain.common.SupportedTypes
import com.v.tpofferwall.domain.model.DataItemInfo
import com.v.tpofferwall.ui.common.components.ShowBlock
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
            ShowBlock(data = it)
            Button(
                modifier = Modifier.align(Alignment.BottomCenter).padding(12.dp),
                onClick = onClick
            ) {
                Text(text = "далее")
            }
        }
    }
}