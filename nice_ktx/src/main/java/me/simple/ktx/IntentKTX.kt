package me.simple.ktx

import android.content.Intent
import android.os.Build
import android.os.Parcelable
import java.io.Serializable

/**
 * getSerializableExtra的兼容方法
 *
 * @since 1.0.4
 */
@Suppress("DEPRECATION")
inline fun <reified T : Serializable> Intent.getSerializableExtraCompat(name: String): T? {
  return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    this.getSerializableExtra(name, T::class.java)
  } else {
    this.getSerializableExtra(name) as? T
  }
}

/**
 * getParcelableExtra的兼容方法
 *
 * @since 1.0.4
 */
@Suppress("DEPRECATION")
inline fun <reified T : Parcelable> Intent.getParcelableExtraCompat(name: String): T? {
  return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    this.getParcelableExtra(name, T::class.java)
  } else {
    this.getParcelableExtra(name) as? T
  }
}