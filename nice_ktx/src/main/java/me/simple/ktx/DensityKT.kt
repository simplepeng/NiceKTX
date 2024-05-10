package me.simple.ktx

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.Fragment

//---------------

/**
 * Resources -- dp转px
 *
 * @since 1.0.2
 */
fun Resources.dp2px(value: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, this.displayMetrics)

/**
 * Resources -- sp转px
 *
 * @since 1.0.2
 */
fun Resources.sp2px(value: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, this.displayMetrics)

/**
 * Resources -- px转dp
 *
 * @since 1.0.4
 */
fun Resources.px2dp(pxValue: Float) = pxValue / this.displayMetrics.density

/**
 * Resources -- px转sp
 *
 * @since 1.0.4
 */
fun Resources.px2sp(pxValue: Float) = pxValue / this.displayMetrics.scaledDensity

//---------------

/**
 * View -- dp转px
 *
 * @since 1.0.2
 */
fun View.dp2px(value: Float) = this.resources.dp2px(value)

/**
 * View -- sp2px
 *
 * @since 1.0.2
 */
fun View.sp2px(value: Float) = this.resources.sp2px(value)

/**
 * View -- px转dp
 *
 * @since 1.0.4
 */
fun View.px2dp(pxValue: Float) = this.resources.px2dp(pxValue)

/**
 * View -- px转sp
 *
 * @since 1.0.4
 */
fun View.px2sp(pxValue: Float) = this.resources.px2sp(pxValue)

//---------------

/**
 * Context -- dp转px
 *
 * @since 1.0.2
 */
fun Context.dp2px(value: Float) = this.resources.dp2px(value)

/**
 * Context -- sp转px
 *
 * @since 1.0.2
 */
fun Context.sp2px(value: Float) = this.resources.sp2px(value)

/**
 * Context -- px2dp
 *
 * @since 1.0.4
 */
fun Context.px2dp(pxValue: Float) = this.resources.px2dp(pxValue)

/**
 * Context -- px转sp
 *
 * @since 1.0.4
 */
fun Context.px2sp(pxValue: Float) = this.resources.px2sp(pxValue)

//---------------

/**
 * Fragment -- dp转px
 *
 * @since 1.0.2
 */
fun Fragment.dp2px(value: Float) = this.resources.dp2px(value)

/**
 * Fragment -- sp转px
 *
 * @since 1.0.2
 */
fun Fragment.sp2px(value: Float) = this.resources.sp2px(value)

/**
 * Fragment -- px转dp
 *
 * @since 1.0.4
 */
fun Fragment.px2dp(pxValue: Float) = this.resources.px2dp(pxValue)

/**
 * Fragment -- px转sp
 *
 * @since 1.0.4
 */
fun Fragment.px2sp(pxValue: Float) = this.resources.px2sp(pxValue)

//---------------

/**
 * Dialog -- dp转px
 *
 * @since 1.0.2
 */
fun Dialog.dp2px(value: Float) = this.context.dp2px(value)

/**
 * Dialog -- sp2px
 *
 * @since 1.0.2
 */
fun Dialog.sp2px(value: Float) = this.context.sp2px(value)

/**
 * Dialog -- px2dp
 *
 * @since 1.0.4
 */
fun Dialog.px2dp(pxValue: Float) = this.context.px2dp(pxValue)

/**
 * Dialog -- px转sp
 *
 * @since 1.0.4
 */
fun Dialog.px2sp(pxValue: Float) = this.context.px2sp(pxValue)

//---------------

/**
 * Number -- dp转px
 *
 * @since 1.0.0
 */
val Float.dp: Float
    get() = Resources.getSystem().dp2px(this)

/**
 * Number -- dp转px
 *
 * @since 1.0.0
 */
val Int.dp: Int
    get() = this.toFloat().dp.toInt()

/**
 * Number -- dp转px
 *
 * @since 1.0.0
 */
val Long.dp: Long
    get() = this.toFloat().dp.toLong()

/**
 * Number -- dp转px
 *
 * @since 1.0.0
 */
val Double.dp: Double
    get() = this.toFloat().dp.toDouble()


/**
 * Number -- sp转px
 *
 * @since 1.0.0
 */
val Float.sp: Float
    get() = Resources.getSystem().sp2px(this)

/**
 * Number -- sp转px
 *
 * @since 1.0.0
 */
val Int.sp: Int
    get() = this.toFloat().sp.toInt()

/**
 * Number -- sp转px
 *
 * @since 1.0.0
 */
val Long.sp: Long
    get() = this.toFloat().sp.toLong()

/**
 * Number -- sp转px
 *
 * @since 1.0.0
 */
val Double.sp: Double
    get() = this.toFloat().sp.toDouble()





