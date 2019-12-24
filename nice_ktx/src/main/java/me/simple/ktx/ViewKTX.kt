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

fun View.setOnSingleClickListener(block:(view:View)->Unit){
    this.setOnClickListener {
        block.invoke(it)
    }
}