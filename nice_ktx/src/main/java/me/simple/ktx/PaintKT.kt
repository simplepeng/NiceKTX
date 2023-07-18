package me.simple.ktx

import android.graphics.Paint
import ktx.common.Desc
import kotlin.math.abs

@Desc("文本高度", "v1.0.4")
val Paint.textHeight: Float
    get() = with(fontMetrics) {
        abs(top) + abs(bottom)
    }

@Desc("文本ascent高度", "v1.0.4")
val Paint.textAscentHeight: Float
    get() = with(fontMetrics) {
        abs(ascent) + abs(descent)
    }