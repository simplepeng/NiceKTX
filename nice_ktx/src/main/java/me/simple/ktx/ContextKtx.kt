package me.simple.ktx

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.Uri
import androidx.annotation.RequiresPermission
import java.lang.Exception

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

/**
 * 获取屏幕宽度
 */
fun Context.getScreenWidth() = Resources.getSystem().displayMetrics.widthPixels

/**
 * 获取屏幕高度
 */
fun Context.getScreenHeight() = Resources.getSystem().displayMetrics.heightPixels

/**
 * 打开网页
 */
fun Context.openWeb(
    url: String,
    onError: (e: Exception) -> Unit = {}
) {
    try {
        val intent = Intent().apply {
            action = "android.intent.action.VIEW"
            val uri = Uri.parse(url)
            data = uri
        }
        this.startActivity(intent)
    } catch (e: Exception) {
        onError.invoke(e)
    }
}

fun Context.sendEmail(
    email: String,
    subject: String? = "",
    onError: (e: Exception) -> Unit = {}
) {
    try {
        val uri = Uri.parse("mailto:$email")
        val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
            putExtra(Intent.EXTRA_CC, email)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        this.startActivity(intent)
    } catch (e: Exception) {
        onError.invoke(e)
    }
}

fun Context.openMarket(
    packageName: String = this.packageName,
    onError: (e: Exception) -> Unit = {}
) {
    try {
        val uri = Uri.parse("market://details?id=${packageName}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        this.startActivity(intent)
    } catch (e: Exception) {
        onError.invoke(e)
    }
}