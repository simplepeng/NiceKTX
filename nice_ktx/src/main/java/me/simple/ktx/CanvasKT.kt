package me.simple.ktx

import android.graphics.Canvas
import android.graphics.Paint
import ktx.common.Desc

@Desc("画文字-以顶部为基准线","v1.0.1")
fun Canvas.drawTextOnTop(
    text: String,
    x: Float,
    y: Float,
    paint: Paint
) {
    val fontMetrics = paint.fontMetrics
    val newY = y - fontMetrics.top
    this.drawText(text, x, newY, paint)
}

@Desc("画文字-以底部为基准线","v1.0.1")
fun Canvas.drawTextOnBottom(
    text: String,
    x: Float,
    y: Float,
    paint: Paint
) {
    val fontMetrics = paint.fontMetrics
    val newY = y - fontMetrics.bottom
    this.drawText(text, x, newY, paint)
}
