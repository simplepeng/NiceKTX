package me.simple.ktxdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import me.simple.ktx.drawTextOnBottom
import me.simple.ktx.drawTextOnTop

class CanvasKTXView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 50f
        color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawTextOnTop("HaHa", 0f, 0f, mPaint)

        canvas.drawTextOnBottom("My", 0f, height.toFloat(), mPaint)
    }
}