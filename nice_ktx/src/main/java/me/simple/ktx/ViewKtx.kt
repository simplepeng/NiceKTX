package me.simple.ktx

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

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
        var lastClickTime = 0L

        val tag: Any? = v.getTag(mTag)
        if (tag == null) {
            v.setTag(mTag, curTime)
            block.invoke(v)
            return
        }

        lastClickTime = tag as Long
        val canClick = curTime - lastClickTime > interval
        if (canClick) {
            v.setTag(mTag, curTime)
            block.invoke(v)
        }
    }
}