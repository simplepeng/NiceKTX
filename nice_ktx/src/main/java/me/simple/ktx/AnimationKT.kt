package me.simple.ktx

import android.view.animation.Animation

fun Animation.onAnimationEnd(block: () -> Unit) {
    this.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            block.invoke()
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }
    })
}

fun Animation.onAnimationStart(block: () -> Unit) {
    this.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
            block.invoke()
        }

        override fun onAnimationEnd(animation: Animation?) {

        }

        override fun onAnimationRepeat(animation: Animation?) {
        }
    })
}

fun Animation.onAnimationRepeat(block: () -> Unit) {
    this.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {

        }

        override fun onAnimationRepeat(animation: Animation?) {
            block.invoke()
        }
    })
}