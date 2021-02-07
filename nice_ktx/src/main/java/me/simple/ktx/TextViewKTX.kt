package me.simple.ktx

import android.graphics.Color
import android.widget.TextView
import ktx.common.Desc

/**
 * 清空文本
 */
fun TextView.clearText() {
    this.text = ""
}

@Desc("设置文字颜色","1.0.1")
fun TextView.setTextColor(colorStr: String) {
    this.setTextColor(Color.parseColor(colorStr))
}