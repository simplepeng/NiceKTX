package me.simple.ktx

import android.content.Context
import android.widget.Toast
import ktx.common.Desc

@Desc("显示吐司", "v1.0.0")
fun Context.showToast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

@Desc("显示吐司", "v1.0.0")
fun Context.showToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

@Desc("显示长吐司", "v1.0.0")
fun Context.showLongToast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
}

@Desc("显示长吐司", "v1.0.0")
fun Context.showLongToast(text: CharSequence) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}