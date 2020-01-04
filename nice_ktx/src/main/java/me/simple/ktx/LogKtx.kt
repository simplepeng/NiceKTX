package me.simple.ktx

import android.util.Log

fun logDebug(tag: String?, msg: String) {
    Log.d(tag, msg)
}

fun logInfo(tag: String?, msg: String) {
    Log.i(tag, msg)
}

fun logWran(tag: String?, msg: String) {
    Log.w(tag, msg)
}

fun logError(tag: String?, msg: String) {
    Log.e(tag, msg)
}

fun logVerbose(tag: String?, msg: String) {
    Log.v(tag, msg)
}