package me.simple.ktx

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import ktx.common.Desc
import me.simple.ktx.helpers.BitmapHelper

@Desc("隐藏View", "1.0")
fun View.gone() {
    this.visibility = View.GONE
}

@Desc("显示View", "1.0")
fun View.visible() {
    this.visibility = View.VISIBLE
}

@Desc("隐藏View，保留位置", "1.0")
fun View.invisible() {
    this.visibility = View.INVISIBLE
}

@Desc("从View的Context中获取Activity", "1.0")
val View.activity: Activity?
    get() = this.context.activity

@Desc("点击事件", "1.0")
fun View.click(block: (view: View) -> Unit) {
    this.setOnClickListener(block)
}

@Desc("防抖动点击事件", "1.0", "1.1", "interval修改为1s")
fun View.singleClick(
    interval: Int = 1000,
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

@Desc("设置背景颜色", "1.0.1")
fun View.setBackgroundColor(colorStr: String) {
    this.setBackgroundColor(Color.parseColor(colorStr))
}


@Desc("是否是从右到左的布局", "1.0.2")
fun View.isLayoutDirectionRTL(): Boolean {
    return ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL
}


@Desc("设置paddingTop", "1.0.2")
var View.paddingTop
    set(value) = this.setPadding(0, value, 0, 0)
    get() = this.paddingTop


@Desc("设置paddingStart", "1.0.2")
var View.paddingStart
    set(value) {
        if (isLayoutDirectionRTL()) {
            this.setPadding(0, 0, value, 0)
        } else {
            this.setPadding(value, 0, 0, 0)
        }
    }
    @SuppressLint("NewApi")
    get() = if (isLayoutDirectionRTL()) {
        this.paddingStart
    } else {
        this.paddingLeft
    }

@Desc("设置paddingEnd", "1.0.2")
var View.paddingEnd
    set(value) {
        if (isLayoutDirectionRTL()) {
            this.setPadding(value, 0, value, 0)
        } else {
            this.setPadding(0, 0, value, 0)
        }
    }
    @SuppressLint("NewApi")
    get() = if (isLayoutDirectionRTL()) {
        this.paddingEnd
    } else {
        this.paddingRight
    }

@Desc("设置paddingBottom", "1.0.2")
var View.paddingBottom
    set(value) = this.setPadding(0, 0, 0, value)
    get() = this.paddingBottom

/**
 * 检查View的LayoutParams是否是MarginLayoutParams
 */
private fun checkIsMarginLayoutParams(view: View) {
    if (view.layoutParams !is ViewGroup.MarginLayoutParams) {
        throw IllegalArgumentException("layoutParams must be MarginLayoutParams")
    }
}

@SuppressLint("NewApi")
@Desc("设置View的margin", "1.0.2")
fun View.setMargin(
    start: Int,
    top: Int,
    end: Int,
    bottom: Int
) {
    checkIsMarginLayoutParams(this)
    val lp = this.layoutParams as ViewGroup.MarginLayoutParams
    lp.topMargin = top
    lp.bottomMargin = bottom
    if (isLayoutDirectionRTL()) {
        lp.marginStart = start
        lp.marginEnd = end
    } else {
        lp.leftMargin = start
        lp.rightMargin = end
    }
}

@Desc("设置marginTop", "1.0.2")
var View.marginTop: Int
    get() {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        return lp.topMargin
    }
    set(value) {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        lp.topMargin = value
    }

@Desc("设置marginBottom", "1.0.2")
var View.marginBottom: Int
    get() {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        return lp.bottomMargin
    }
    set(value) {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        lp.bottomMargin = value
    }

@Desc("设置marginStart", "1.0.2")
var View.marginStart: Int
    @SuppressLint("NewApi")
    get() {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        return if (isLayoutDirectionRTL()) {
            lp.marginStart
        } else {
            lp.leftMargin
        }
    }
    @SuppressLint("NewApi")
    set(value) {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        if (isLayoutDirectionRTL()) {
            lp.marginStart = value
        } else {
            lp.leftMargin = value
        }
    }

@Desc("设置marginEnd", "1.0.2")
var View.marginEnd: Int
    @SuppressLint("NewApi")
    get() {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        return if (isLayoutDirectionRTL()) {
            lp.marginEnd
        } else {
            lp.rightMargin
        }
    }
    @SuppressLint("NewApi")
    set(value) {
        checkIsMarginLayoutParams(this)
        val lp = this.layoutParams as ViewGroup.MarginLayoutParams
        if (isLayoutDirectionRTL()) {
            lp.marginEnd = value
        } else {
            lp.rightMargin = value
        }
    }

@Desc("设置缩放的背景图", "1.0.2")
fun View.setScaleBackground(
    resId: Int,
    inSampleSize: Int = 2
) {
    val scaleDrawable = BitmapHelper.scaleBitmapDrawable(this.resources, resId, inSampleSize)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        this.background = scaleDrawable
    } else {
        this.setBackgroundDrawable(scaleDrawable)
    }
}






