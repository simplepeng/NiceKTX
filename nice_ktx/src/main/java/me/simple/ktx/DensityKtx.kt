package me.simple.ktx

import android.content.res.Resources

val Float.dp: Float
    get() = Resources.getSystem().displayMetrics.density * this + 0.5f

val Int.dp: Int
    get() = this.toFloat().dp.toInt()

val Long.dp: Long
    get() = this.toFloat().dp.toLong()

val Double.dp: Double
    get() = this.toFloat().dp.toDouble()

