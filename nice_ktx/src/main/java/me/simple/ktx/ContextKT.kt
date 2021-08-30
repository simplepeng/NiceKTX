package me.simple.ktx

import android.app.Activity
import android.content.*
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.Uri
import androidx.annotation.RequiresPermission
import ktx.common.Desc

@Desc("网络是否连接", "v1.0.0")
@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isConnected(): Boolean {
    val conn = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = conn.activeNetworkInfo ?: return false
    return networkInfo.isAvailable && networkInfo.isConnected
}

@Desc("从Context获取Activity", "v1.0.0")
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

@Desc("获取屏幕宽度", "v1.0.0")
val Context.screenWidth
    get() = Resources.getSystem().displayMetrics.widthPixels

@Desc("获取屏幕高度", "v1.0.0")
val Context.screenHeight
    get() = Resources.getSystem().displayMetrics.heightPixels

@Desc("打开网页", "v1.0.0", "v1.0.2", "去掉try")
fun Context.openWeb(url: String) {
    val intent = Intent().apply {
        action = "android.intent.action.VIEW"
        val uri = Uri.parse(url)
        data = uri
    }
    this.startActivity(intent)
}

@Desc("发送Email", "v1.0.0", "v1.0.2", "去掉try")
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

@Desc("打开应用商店", "v1.0.0", "v1.0.2", "去掉try")
fun Context.openMarket(
    packageName: String = this.packageName
) {
    val uri = Uri.parse("market://details?id=${packageName}")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    this.startActivity(intent)
}

@Desc("复制文本", "v1.0.0")
fun Context.copyText(
    text: String,
    label: String
) {
    val cm = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData = ClipData.newPlainText(label, text)
    cm.setPrimaryClip(clipData)
}