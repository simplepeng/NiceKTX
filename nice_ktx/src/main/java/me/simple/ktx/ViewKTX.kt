package me.simple.ktx

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt

/**
 * 隐藏View
 */
fun View.gone() {
    this.visibility = View.GONE
}

/**
 * 显示View
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

/**
 * 隐藏View，保留位置
 */
fun View.invisible() {
    this.visibility = View.INVISIBLE
}

/**
 * 从View的Context中获取Activity
 */
val View.activity: Activity?
    get() = this.context.activity


/**
 * 点击事件
 */
fun View.click(block: (view: View) -> Unit) {
    this.setOnClickListener(block)
}

/**
 * 防抖动点击事件
 */
fun View.singleClick(
    interval: Int = 300,
    block: (view: View) -> Unit
) {
    this.setOnClickListener(SingleClickListener(interval, block))
}

class SingleClickListener(
    private var interval: Int,
    private var block: (view: View) -> Unit
) : View.OnClickListener {

    private var mTag = -11

    override fun onClick(v: View) {
        val curTime = System.currentTimeMillis()

        val tag: Any? = v.getTag(mTag)
        if (tag == null) {
            v.setTag(mTag, curTime)
            block.invoke(v)
            return
        }

        val lastClickTime = tag as Long
        val canClick = curTime - lastClickTime > interval
        if (canClick) {
            block.invoke(v)
            v.setTag(mTag, curTime)
        }
    }
}

enum class Shape {
    RECTANGLE,
    OVAL,
    LINE,
    RING,
}

private fun setBackground(
    view: View,
    drawable: GradientDrawable,
    shape: Shape
) {

    when (shape) {
        Shape.RECTANGLE -> {
            drawable.shape = GradientDrawable.RECTANGLE
        }
        Shape.OVAL -> {
            drawable.shape = GradientDrawable.OVAL
        }
        Shape.LINE -> {
            drawable.shape = GradientDrawable.LINE
        }
        Shape.RING -> {
            drawable.shape = GradientDrawable.RING
        }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        view.background = drawable
    } else {
        view.setBackgroundDrawable(drawable)
    }
}

/**
 * 设置View的背景
 */
fun View.shape(
    radius: Float,
    solidColor: Int,
    strokeWidth: Int = 0,
    strokeColor: Int = Color.TRANSPARENT,
    dashWidth: Float = 0f,
    dashGap: Float = 0f,
    shape: Shape = Shape.RECTANGLE
) {
    val drawable = GradientDrawable().apply {
        cornerRadius = radius
        setColor(solidColor)
        if (strokeWidth != 0) {
            setStroke(strokeWidth, strokeColor, dashWidth, dashGap)
        }
    }
    setBackground(this, drawable, shape)
}

/**
 * 设置View的背景
 */
fun View.shape(
    topLeftRadius: Float,
    topRightRadius: Float,
    bottomLeftRadius: Float,
    bottomRightRadius: Float,
    solidColor: Int,
    strokeWidth: Int = 0,
    strokeColor: Int = Color.TRANSPARENT,
    dashWidth: Float = 0f,
    dashGap: Float = 0f,
    shape: Shape = Shape.RECTANGLE
) {
    val drawable = GradientDrawable().apply {
        cornerRadii = floatArrayOf(
            topLeftRadius, topLeftRadius,
            topRightRadius, topRightRadius,
            bottomRightRadius, bottomRightRadius,
            bottomLeftRadius, bottomLeftRadius
        )
        setColor(solidColor)
        if (strokeWidth != 0) {
            setStroke(strokeWidth, strokeColor, dashWidth, dashGap)
        }
    }
    setBackground(this, drawable, shape)
}

/**
 * 圆角矩形-圆角radius为View高度的一半）
 */
fun View.halfRoundRect(solidColor: Int) {
    this.post {
        this.roundRect(this.height / 2f, solidColor)
    }
}

/**
 * 圆角矩形
 */
fun View.roundRect(
    radius: Float,
    solidColor: Int
) {
    this.shape(radius, solidColor)
}

/**
 * 设置渐变的shape
 */
fun View.gradientShape(
    @ColorInt colors: IntArray,
    orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT,
    shape: Shape = Shape.RECTANGLE,
    gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
    useLevel: Boolean = false
) {
    val drawable = GradientDrawable(orientation, colors)
    drawable.gradientType = gradientType
    drawable.useLevel = useLevel

    setBackground(this, drawable, shape)
}

/**
 * 设置渐变的shape，带圆角
 */
fun View.gradientShape(
    radius: Float,
    @ColorInt colors: IntArray,
    orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT,
    shape: Shape = Shape.RECTANGLE,
    gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
    useLevel: Boolean = false
) {
    val drawable = GradientDrawable(orientation, colors)
    drawable.gradientType = gradientType
    drawable.cornerRadius = radius
    drawable.useLevel = useLevel

    setBackground(this, drawable, shape)
}

/**
 * 设置渐变的shape，带圆角,left,top,right,bottom
 */
fun View.gradientShape(
    topLeftRadius: Float,
    topRightRadius: Float,
    bottomLeftRadius: Float,
    bottomRightRadius: Float,
    @ColorInt colors: IntArray,
    orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT,
    shape: Shape = Shape.RECTANGLE,
    gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
    useLevel: Boolean = false
) {
    val drawable = GradientDrawable(orientation, colors)
    drawable.gradientType = gradientType
    drawable.cornerRadii = floatArrayOf(
        topLeftRadius, topLeftRadius,
        topRightRadius, topRightRadius,
        bottomRightRadius, bottomRightRadius,
        bottomLeftRadius, bottomLeftRadius
    )
    drawable.useLevel = useLevel

    setBackground(this, drawable, shape)
}

/**
 * 设置渐变的shape，带圆角，圆角为View高度的一半
 */
fun View.halfGradientShape(
    @ColorInt colors: IntArray
) {
    this.post {
        gradientShape(this.height / 2f, colors)
    }
}


