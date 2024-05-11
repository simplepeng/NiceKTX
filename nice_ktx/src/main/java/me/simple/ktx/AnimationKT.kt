package me.simple.ktx

import android.view.animation.Animation

/**
 * 监听动画变化的回调
 * @since 1.0.4
 */
fun Animation.onAnimationChange(
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
 * 动画开始的回调
 *
 * @since 1.0.4
 */
fun Animation.onAnimationStart(action: (animation: Animation?) -> Unit) {
    onAnimationChange(onAnimationStart = action)
}

/**
 * 动画结束的回调
 *
 * @since 1.0.4
 */
fun Animation.doOnAnimationEnd(action: (animation: Animation?) -> Unit) {
    onAnimationChange(onAnimationEnd = action)
}


/**
 * 动画循环的回调
 * @since 1.0.4
 */
fun Animation.doOnAnimationRepeat(action: (animation: Animation?) -> Unit) {
    onAnimationChange(onAnimationRepeat = action)
}