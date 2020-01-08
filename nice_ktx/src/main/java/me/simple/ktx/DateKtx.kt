package me.simple.ktx

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss"
private val SDF_THREAD_LOCAL = ThreadLocal<SimpleDateFormat>()

fun Long.toDateString(format: DateFormat = getDefaultFormat()): String {
    return format.format(Date(this))
}

fun Long.toDateString(format: String = yyyy_MM_dd_HH_mm_ss): String {
    return this.toDateString(getDateFormat(format))
}

fun String.toMillis(format: DateFormat = getDefaultFormat()): Long {
    return string2Millis(this, format)
}

fun String.toMillis(format: String = yyyy_MM_dd_HH_mm_ss): Long {
    return this.toMillis(getDateFormat(format))
}

private fun string2Millis(time: String, format: DateFormat): Long {
    try {
        return format.parse(time).time
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return -1
}

private fun getDefaultFormat(): SimpleDateFormat {
    return getDateFormat("yyyy-MM-dd HH:mm:ss")
}

private fun getDateFormat(pattern: String): SimpleDateFormat {
    var simpleDateFormat: SimpleDateFormat? = SDF_THREAD_LOCAL.get()
    if (simpleDateFormat == null) {
        simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        SDF_THREAD_LOCAL.set(simpleDateFormat)
    } else {
        simpleDateFormat.applyPattern(pattern)
    }
    return simpleDateFormat
}