package com.v.tpofferwall

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.v.tpofferwall.ui.theme.TPOfferWallTheme
import com.v.tpofferwall.ui.typeshow.TypeShowScreen
import com.v.tpofferwall.ui.typeshow.TypeShowVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPOfferWallTheme {
                val vm = viewModel<TypeShowVM>()
                LaunchedEffect(vm){
                    vm.initGetItem()
                }
                Surface(color = MaterialTheme.colors.background) {
                    TypeShowScreen(vm = vm)
                }
            }
        }
    }
}