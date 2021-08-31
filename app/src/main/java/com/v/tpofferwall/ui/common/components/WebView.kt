package com.v.tpofferwall.ui.common.components

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.JsPromptResult

import android.webkit.JsResult




@Composable
fun WebView(url:String) {
    AndroidView(
    modifier = Modifier.fillMaxSize(), // Occupy the max size in the Compose UI tree
    factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webChromeClient =object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: JsResult?
                ): Boolean {
                    return true
                }

                override fun onJsConfirm(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: JsResult?
                ): Boolean {
                    return true
                }

                override fun onJsPrompt(
                    view: WebView?, url: String?, message: String?, defaultValue: String?,
                    result: JsPromptResult?
                ): Boolean {
                    return true
                }
            }
            webViewClient = object : WebViewClient() {
            }
            loadUrl(url)
        }
    },
    update = { view ->
        view.loadUrl(url)
    })
}