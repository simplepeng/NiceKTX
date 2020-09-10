package me.simple.ktx

import android.content.res.Resources

/**
 * dp 2 px
 */
val Int.dp: Int
    get() = this.toFloat().dp.toInt()

val Long.dp: Long
    get() = this.toFloat().dp.toLong()

val Double.dp: Double
    get() = this.toFloat().dp.toDouble()

val Float.dp: Float
    get() = Resources.getSystem().displayMetrics.density * this + 0.5f

/**
 * sp 2 px
 */
val Int.sp: Int
    get() = this.toFloat().sp.toInt()

val Long.sp: Long
    get() = this.toFloat().sp.toLong()

val Double.sp: Double
    get() = this.toFloat().sp.toDouble()

val Float.sp: Float
    get() = this / Resources.getSystem().displayMetrics.scaledDensity + 0.5f

