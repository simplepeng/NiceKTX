package me.simple.ktx

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import ktx.common.Desc

@Desc("Resources dp转px", "1.0.2")
fun Resources.dp2px(value: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, this.displayMetrics)

@Desc("Resources sp转px", "1.0.2")
fun Resources.sp2px(value: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, this.displayMetrics)

@Desc("View dp转px", "1.0.2")
fun View.dp2px(value: Float) = this.resources.dp2px(value)

@Desc("View sp转px", "1.0.2")
fun View.sp2px(value: Float) = this.resources.sp2px(value)


@Desc("Context dp转px", "1.0.2")
fun Context.dp2px(value: Float) = this.resources.dp2px(value)

@Desc("Context sp转px", "1.0.2")
fun Context.sp2px(value: Float) = this.resources.sp2px(value)


@Desc("Dialog dp转px", "1.0.2")
fun Dialog.dp2px(value: Float) = this.context.dp2px(value)

@Desc("Dialog sp转px", "1.0.2")
fun Dialog.sp2px(value: Float) = this.context.sp2px(value)


@Desc("Number dp转px", "1.0.0", "1.0.2", "使用TypedValue")
val Float.dp: Float
    get() = Resources.getSystem().dp2px(this)

val Int.dp: Int
    get() = this.toFloat().dp.toInt()

val Long.dp: Long
    get() = this.toFloat().dp.toLong()

val Double.dp: Double
    get() = this.toFloat().dp.toDouble()


@Desc("Number sp转px", "1.0.0", "1.0.2", "使用TypedValue")
val Float.sp: Float
    get() = Resources.getSystem().sp2px(this)

val Int.sp: Int
    get() = this.toFloat().sp.toInt()

val Long.sp: Long
    get() = this.toFloat().sp.toLong()

val Double.sp: Double
    get() = this.toFloat().sp.toDouble()




