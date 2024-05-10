package me.simple.ktx

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import me.simple.ktx.helpers.BitmapHelper

/**
 * 隐藏View
 *
 *  @since 1.0.0
 */
fun View.gone() {
    this.visibility = View.GONE
}

/**
 * 显示View
 *
 *  @since 1.0.0
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

/**
 * 隐藏View
 *
 *  @since 1.0.0
 */
fun View.invisible() {
    this.visibility = View.INVISIBLE
}

/**
 * 从View的Context中获取Activity
 *
 *  @since 1.0.0
 */
val View.activity: Activity?
    get() = this.context.activity

/**
 * 点击事件
 *
 * @since 1.0.0
 */
fun View.click(block: (view: View) -> Unit) {
    this.setOnClickListener(block)
}

/**
 * 防抖动点击事件
 *
 * @since 1.0.1
 */
fun View.singleClick(
    interval: Int = 1000,
    block: (view: View) -> Unit
) {
    this.setOnClickListener(SingleClickListener(interval, block))
}

/**
 * @suppress
 */
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

/**
 * 设置背景颜色
 *
 * @since 1.0.2
 */
fun View.setBackgroundColor(colorStr: String) {
    this.setBackgroundColor(Color.parseColor(colorStr))
}

/**
 * 是否是从右到左的布局
 *
 * @since 1.0.2
 */
fun View.isLayoutDirectionRTL(): Boolean {
    return ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL
}

/**
 * 设置paddingTop
 *
 * @since 1.0.2
 */
fun View.setPaddingTop(value: Int) {
    this.setPadding(0, value, 0, 0)
}

/**
 * 设置paddingStart
 *
 * @since 1.0.2
 */
fun View.setPaddingStart(value: Int) {
    if (isLayoutDirectionRTL()) {
        this.setPadding(0, 0, value, 0)
    } else {
        this.setPadding(value, 0, 0, 0)
    }
}

/**
 * 设置paddingEnd
 *
 * @since 1.0.2
 */
fun View.setPaddingEnd(value: Int) {
    if (isLayoutDirectionRTL()) {
        this.setPadding(value, 0, 0, 0)
    } else {
        this.setPadding(0, 0, value, 0)
    }
}

/**
 * 设置paddingBottom
 *
 * @since 1.0.2
 */
fun View.setPaddingBottom(value: Int) {
    this.setPadding(0, 0, 0, value)
}

/**
 * 检查View的LayoutParams是否是MarginLayoutParams
 *
 * @suppress
 */
private fun checkIsMarginLayoutParams(view: View) {
    if (view.layoutParams !is ViewGroup.MarginLayoutParams) {
        throw IllegalArgumentException("layoutParams must be MarginLayoutParams")
    }
}

/**
 * 设置View的margin
 *
 * @since 1.0.2
 */
@SuppressLint("NewApi")
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
    this.layoutParams = lp
}

/**
 * @since 1.0.2
 */
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
        this.layoutParams = lp
    }

/**
 * @since 1.0.2
 */
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
        this.layoutParams = lp
    }

/**
 * @since 1.0.2
 */
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
        this.layoutParams = lp
    }

/**
 * @since 1.0.2
 */
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
        this.layoutParams = lp
    }

/**
 * 设置缩放的背景图
 * @since 1.0.2
 */
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

/**
 * 检查View是否有父布局
 *
 * @since 1.0.4
 */
fun View.hasParent() = this.parent != null

/**
 * 从父布局里面删除自己
 *
 * @since 1.0.4
 */
fun View.removeFromParent() {
    this.parent?.let {
        (it as ViewGroup).removeView(this)
    }
}




