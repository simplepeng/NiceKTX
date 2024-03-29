package com.youloft.andclock.ext

import android.content.Intent
import android.os.Build
import java.io.Serializable

@Suppress("DEPRECATION")
inline fun <reified T : Serializable> Intent.getSerializableExtraCompat(
    name: String
): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializableExtra(name, T::class.java)
    } else {
        this.getSerializableExtra(name) as? T
    }
}

@Suppress("DEPRECATION")
inline fun <reified T : Serializable> Intent.getParcelableExtraCompat(
    name: String
): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelableExtra(name, T::class.java)
    } else {
        this.getParcelableExtra(name) as? T
    }
}