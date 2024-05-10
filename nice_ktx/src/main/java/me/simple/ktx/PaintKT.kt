package me.simple.ktx

import android.graphics.Paint
import kotlin.math.abs

/**
 * 文本高度
 *
 * @since 1.0.4
 */
val Paint.textHeight: Float
    get() = with(fontMetrics) {
        abs(top) + abs(bottom)
    }

/**
 * 文本ascent高度
 *
 * @since 1.0.4
 */
val Paint.textAscentHeight: Float
    get() = with(fontMetrics) {
        abs(ascent) + abs(descent)
    }