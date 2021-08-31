package com.v.tpofferwall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
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
                    vm.VMInit()
                }
                Surface(color = MaterialTheme.colors.background) {
                    TypeShowScreen(vm = vm)
                }
            }
        }
    }
}