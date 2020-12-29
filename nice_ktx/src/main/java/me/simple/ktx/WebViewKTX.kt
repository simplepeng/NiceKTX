package me.simple.ktx

import android.webkit.WebView

/**
 * 加载asset目录下的html文件
 */
fun WebView.loadAsset(path: String) {
    this.loadUrl("file:///android_asset/$path")
}

/**
 * 调用js的方法
 */
fun WebView.callJsMethod(methodName: String) {
    this.loadUrl("javascript:${methodName}()")
}