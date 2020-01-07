package me.simple.ktx

import android.app.Activity
import android.view.View

val View.isGone: Boolean
    get() {
        return this.visibility == View.GONE
    }

val View.isVisible: Boolean
    get() {
        return this.visibility == View.VISIBLE
    }

val View.isInvisible: Boolean
    get() {
        return this.visibility == View.INVISIBLE
    }

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.getActivity(): Activity? {
    return this.context.getActivity()
}

/**
 * 防抖动点击事件
 */
fun View.setOnDebounceClickListener(
    interval: Int = 300,
    block: (view: View?) -> Unit
) {
    this.setOnClickListener(OnDebounceClickListener(interval, block))
}

class OnDebounceClickListener(
    private var interval: Int,
    private var block: (view: View?) -> Unit
) : View.OnClickListener {

    private var mTag = -11

    override fun onClick(v: View?) {
        if (v == null) {
            block.invoke(v)
            return
        }

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