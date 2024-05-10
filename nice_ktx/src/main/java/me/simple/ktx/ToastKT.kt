package me.simple.ktx

import android.content.Context
import android.widget.Toast

/**
 * 显示吐司
 *
 * @since 1.0.0
 */
fun Context.showToast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

/**
 * 显示吐司
 *
 * @since 1.0.0
 */
fun Context.showToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

/**
 * 显示长吐司
 *
 * @since 1.0.0
 */
fun Context.showLongToast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
}

/**
 * 显示长吐司
 *
 * @since 1.0.0
 */
fun Context.showLongToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}