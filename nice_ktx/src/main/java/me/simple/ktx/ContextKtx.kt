package me.simple.ktx

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Resources
import android.net.ConnectivityManager
import androidx.annotation.RequiresPermission

@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.haveNetwork(): Boolean {
    val conn = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = conn.activeNetworkInfo ?: return false

    return networkInfo.isAvailable && networkInfo.isConnected
}

fun Context.getActivity(): Activity? {
    if (this is Activity) return this

    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }

    return null
}

fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun getScreenHeight() = Resources.getSystem().displayMetrics.heightPixels