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
    duration: Int = 300,
    block: (view: View?) -> Unit
) {
    this.setOnClickListener(OnDebounceClickListener(duration, block))
}

class OnDebounceClickListener(
    private var duration: Int = 300,
    private var block: (view: View?) -> Unit
) : View.OnClickListener {

    private var mEnable = true
    private var mTag = -11

    override fun onClick(v: View?) {
        if (v == null) {
            block.invoke(v)
            return
        }
        val tag = v.getTag(mTag)
        if (tag is Long){

        }

        val currentTimeMillis = System.currentTimeMillis()

        if (mEnable) return


        block.invoke(v)
    }
}