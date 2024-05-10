package me.simple.ktx

import android.content.Context
import android.net.Uri

/**
 * 将res-raw目录下的资源转换成Uri
 *
 * @since 1.0.2
 */
fun Int.toUri(
    context: Context
): Uri {
    return context.rawIdToUri(this, context.packageName)
}

/**
 * 将res-raw目录下的资源转换成Uri
 *
 * @since 1.0.2
 */
fun Context.rawIdToUri(
    rawId: Int,
    packageName: String = this.packageName
): Uri {
    return Uri.parse("android.resource://$packageName/$rawId")
}

