package me.simple.ktx

import android.util.Log

fun String.logV(tag: String = NiceKtx.logTag) {
    Log.v(tag, this)
}

fun String.logD(tag: String = NiceKtx.logTag) {
    Log.d(tag, this)
}

fun String.logI(tag: String = NiceKtx.logTag) {
    Log.i(tag, this)
}

fun String.logW(tag: String = NiceKtx.logTag) {
    Log.w(tag, this)
}

fun String.logE(tag: String = NiceKtx.logTag) {
    Log.e(tag, this)
}
