package me.simple.ktx

import java.util.Calendar

val Calendar.year: Int
    get() = get(Calendar.YEAR)

val Calendar.month: Int
    get() = get(Calendar.MONTH) + 1

val Calendar.day: Int
    get() = get(Calendar.DAY_OF_MONTH)