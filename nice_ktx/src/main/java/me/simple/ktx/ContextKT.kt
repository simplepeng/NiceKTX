package me.simple.ktx

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.Uri
import androidx.annotation.RequiresPermission

/**
 * 网络是否连接
 *
 * @since 1.0.0
 */
@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isConnected(): Boolean {
    val conn = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = conn.activeNetworkInfo ?: return false
    return networkInfo.isAvailable && networkInfo.isConnected
}

/**
 * 从Context获取Activity
 *
 * @since 1.0.0
 */
val Context.activity: Activity?
    get() {
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
 *
 * @since 1.0.0
 */
val Context.screenWidth
    get() = Resources.getSystem().displayMetrics.widthPixels

/**
 * 获取屏幕高度
 *
 * @since 1.0.0
 */
val Context.screenHeight
    get() = Resources.getSystem().displayMetrics.heightPixels

/**
 * 打开网页
 *
 * @since 1.0.0
 */
fun Context.openWeb(url: String) {
    val intent = Intent().apply {
        action = "android.intent.action.VIEW"
        val uri = Uri.parse(url)
        data = uri
    }
    this.startActivity(intent)
}

/**
 * 发送Email
 *
 * @since 1.0.0
 */
fun Context.sendEmail(
    email: String,
    subject: String? = ""
) {
    val uri = Uri.parse("mailto:$email")
    val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
        putExtra(Intent.EXTRA_CC, email)
        putExtra(Intent.EXTRA_SUBJECT, subject)
    }
    this.startActivity(intent)
}

/**
 * 打开应用商店
 *
 * @since 1.0.0
 */
fun Context.openMarket(
    packageName: String = this.packageName
) {
    val uri = Uri.parse("market://details?id=${packageName}")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    this.startActivity(intent)
}

/**
 * 复制文本
 *
 * @since 1.0.0
 */
fun Context.copyText(
    text: String,
    label: String
) {
    val cm = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData = ClipData.newPlainText(label, text)
    cm.setPrimaryClip(clipData)
}