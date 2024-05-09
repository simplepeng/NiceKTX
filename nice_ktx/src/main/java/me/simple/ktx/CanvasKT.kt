package me.simple.ktx

import android.graphics.Canvas
import android.graphics.Paint

/**
 * 画文字-以顶部为基准线
 *
 * @since 1.0.1
 */
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

/**
 * 画文字-以底部为基准线
 *
 * @since 1.0.1
 */
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

/**
 * 画文字-以中心点为基准
 *
 * @since 1.0.1
 */
fun Canvas.drawTextOnCenter(
    text: String,
    x: Float,
    y: Float,
    paint: Paint,
    textAlign: Paint.Align = Paint.Align.CENTER
) {
    val tmpAlign = paint.textAlign
    val fm = paint.fontMetrics
    val newY = y + ((fm.descent - fm.ascent) / 2 - fm.descent)
    paint.textAlign = textAlign
    this.drawText(text, x, newY, paint)
    paint.textAlign = tmpAlign
}