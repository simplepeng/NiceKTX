package me.simple.ktx

import android.graphics.Color
import android.widget.TextView

/**
 * 清空文本
 *
 * @since 1.0.0
 */
fun TextView.clearText() {
    this.text = ""
}

/**
 * 设置文字颜色
 *
 * @since 1.0.1
 */
fun TextView.setTextColor(colorStr: String) {
    this.setTextColor(Color.parseColor(colorStr))
}