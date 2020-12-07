package me.simple.ktx

import android.webkit.WebView

fun WebView.loadAsset(path: String) {
    this.loadUrl("file:///android_asset/$path")
}