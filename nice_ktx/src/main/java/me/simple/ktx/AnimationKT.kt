package me.simple.ktx

import android.view.animation.Animation
import ktx.common.Desc

@Desc("","v1.0.4")
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

@Desc("","v1.0.4")
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

@Desc("","v1.0.4")
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