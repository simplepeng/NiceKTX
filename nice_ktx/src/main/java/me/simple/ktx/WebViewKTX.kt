package me.simple.ktx

import android.webkit.WebView
import ktx.common.Desc

@Desc("加载asset目录下的html文件", "v1.0.1")
fun WebView.loadAsset(path: String) {
    this.loadUrl("file:///android_asset/$path")
}

@Desc("调用js的方法", "v1.0.1")
fun WebView.callJsMethod(methodName: String) {
    this.loadUrl("javascript:${methodName}()")
}