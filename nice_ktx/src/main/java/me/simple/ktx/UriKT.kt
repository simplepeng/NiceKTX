package me.simple.ktx

import android.content.Context
import android.net.Uri
import ktx.common.Desc

@Desc("将res-raw目录下的资源转换成Uri", "v1.0.2")
fun Int.toUri(
    context: Context
): Uri {
    return context.rawIdToUri(this, context.packageName)
}

@Desc("将res-raw目录下的资源转换成Uri", "v1.0.2")
fun Context.rawIdToUri(
    rawId: Int,
    packageName: String = this.packageName
): Uri {
    return Uri.parse("android.resource://$packageName/$rawId")
}

