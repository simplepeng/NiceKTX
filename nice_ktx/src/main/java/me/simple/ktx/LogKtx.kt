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

fun logVerbose(msg: String, tag: String = NiceKtx.logTag) {
    Log.v(tag, msg)
}

fun logDebug(msg: String, tag: String = NiceKtx.logTag) {
    Log.d(tag, msg)
}

fun logInfo(msg: String, tag: String = NiceKtx.logTag) {
    Log.i(tag, msg)
}

fun logWarn(msg: String, tag: String = NiceKtx.logTag) {
    Log.w(tag, msg)
}

fun logError(msg: String, tag: String = NiceKtx.logTag) {
    Log.e(tag, msg)
}

