package com.v.tpofferwall.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.v.tpofferwall.domain.common.SupportedTypes
import com.v.tpofferwall.domain.model.DataItemInfo

@Composable
fun ShowBlock(
    data:DataItemInfo
) {
    when(data.type){
        SupportedTypes.TEXT->{
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = data.message!!
                )
            }

        }
        SupportedTypes.IMAGE ->{
            Image(
                painter = rememberImagePainter(
                    data=data.url,
                    builder = {
                        crossfade(true)
                    },
                ),
                contentScale= ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            )
        }
        SupportedTypes.WEBVIEW ->{
            WebView(url = data.url!!)
        }
    }
}