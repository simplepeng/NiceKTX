package me.simple.ktx

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View

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

/**
 * 设置背景
 */
fun View.background(shape: Shape = Shape.RECTANGLE): ShapeCreator {
    val creator = ShapeCreator(this)
    creator.shape = shape
    return creator
}

class ShapeCreator(private val view: View) {

    var shape: Shape = Shape.RECTANGLE
    var solid: Int = Color.WHITE

    fun render() {
        val d = GradientDrawable().apply {
            shape = setShape(this@ShapeCreator.shape)
            setColor(solid)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.background = d
        } else {
            view.setBackgroundDrawable(d)
        }
    }

    private fun setShape(shape: Shape): Int {
        return when (shape) {
            Shape.RECTANGLE -> {
                GradientDrawable.RECTANGLE
            }
            Shape.OVAL -> {
                GradientDrawable.OVAL
            }
            Shape.LINE -> {
                GradientDrawable.LINE
            }
            Shape.RING -> {
                GradientDrawable.RING
            }
        }
    }
}
