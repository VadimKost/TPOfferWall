package com.v.tpofferwall.ui.common.components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebView(url:String) {
    AndroidView(
    modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
    factory = { context ->
        WebView(context).apply {
            webViewClient = object : WebViewClient() {
            }
            loadUrl(url)
        }
    },
    update = { view ->
        view.loadUrl(url)
    })
}