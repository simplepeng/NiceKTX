package me.simple.ktx

import android.view.animation.Animation

/**
 *
 * @since 1.0.4
 */
fun Animation.setAnimationListenerKT(
    onAnimationStart: (animation: Animation?) -> Unit = {},
    onAnimationEnd: (animation: Animation?) -> Unit = {},
    onAnimationRepeat: (animation: Animation?) -> Unit = {},
) {
    val listener = object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
            onAnimationStart.invoke(animation)
        }

        override fun onAnimationEnd(animation: Animation?) {
            onAnimationEnd.invoke(animation)
        }

        override fun onAnimationRepeat(animation: Animation?) {
            onAnimationRepeat.invoke(animation)
        }
    }
    this.setAnimationListener(listener)
}

/**
 *
 * @since 1.0.4
 */
fun Animation.onAnimationStart(action: (animation: Animation?) -> Unit) {
    setAnimationListenerKT(onAnimationStart = action)
}

/**
 *
 * @since 1.0.4
 */
fun Animation.doOnAnimationEnd(action: (animation: Animation?) -> Unit) {
    setAnimationListenerKT(onAnimationEnd = action)
}


/**
 *
 * @since 1.0.4
 */
fun Animation.doOnAnimationRepeat(action: (animation: Animation?) -> Unit) {
    setAnimationListenerKT(onAnimationRepeat = action)
}