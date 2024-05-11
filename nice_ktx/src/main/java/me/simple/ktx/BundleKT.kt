package me.simple.ktx

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * getSerializableExtra的兼容写法
 *
 * @since 1.0.4
 */
@Suppress("DEPRECATION")
inline fun <reified T : Serializable> Bundle.getSerializableExtraCompat(
    name: String
): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getSerializable(name, T::class.java)
    } else {
        this.getSerializable(name) as? T
    }
}

/**
 * getParcelableExtra的兼容写法
 *
 * @since 1.0.4
 */
@Suppress("DEPRECATION")
inline fun <reified T : Parcelable> Bundle.getParcelableExtraCompat(
    name: String
): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelable(name, T::class.java)
    } else {
        this.getParcelable(name) as? T
    }
}