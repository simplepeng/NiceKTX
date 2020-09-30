package me.simple.ktx

import android.net.Uri

/**
 *将 res-raw目录下的资源转换成Uri
 */
fun Uri.parseRaw(
    packageName: String,
    resId: Int
): Uri {
    return Uri.parse("android.resource://$packageName/$resId")
}

