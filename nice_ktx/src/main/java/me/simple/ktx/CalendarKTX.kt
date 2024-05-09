package me.simple.ktx

import java.util.Calendar

/**
 * 哪年
 *
 * @since 1.0.4
 */
var Calendar.year: Int
  get() = get(Calendar.YEAR)
  set(value) = set(Calendar.YEAR, value)

/**
 * 哪月
 *
 * @since 1.0.4
 */
var Calendar.month: Int
  get() = get(Calendar.MONTH) + 1
  set(value) = set(Calendar.MONTH, value - 1)

/**
 * 哪天
 *
 * @since 1.0.4
 */
var Calendar.dayOfMonth: Int
  get() = get(Calendar.DAY_OF_MONTH)
  set(value) = set(Calendar.DAY_OF_MONTH, value)

/**
 * 当月有多少天
 *
 * @since 1.0.4
 */
val Calendar.daysInMonth: Int
  get() = getActualMaximum(Calendar.DAY_OF_MONTH)

/**
 * 一年的第几天
 *
 * @since 1.0.4
 */
var Calendar.dayOfYear: Int
  get() = get(Calendar.DAY_OF_YEAR)
  set(value) = set(Calendar.DAY_OF_YEAR, value)

/**
 *  24小时制的hour
 *
 *  @since 1.0.4
 */
var Calendar.hourOfDay: Int
  get() = get(Calendar.HOUR_OF_DAY)
  set(value) = set(Calendar.HOUR_OF_DAY, value)

/**
 * 12小时制的hour
 *
 * @since 1.0.4
 */
var Calendar.hour: Int
  get() = get(Calendar.HOUR)
  set(value) = set(Calendar.HOUR, value)

/**
 * 几分
 *
 * @since 1.0.4
 */
val Calendar.minute: Int
  get() = get(Calendar.MINUTE)

/**
 * 重设到月初
 *
 * @since 1.0.4
 */
fun Calendar.resetToMonthStart() {
  set(Calendar.DAY_OF_MONTH, 1)
  set(Calendar.HOUR_OF_DAY, 0)
  set(Calendar.MINUTE, 0)
  set(Calendar.SECOND, 0)
  set(Calendar.MILLISECOND, 0)
}

/**
 * 是否为同一天
 *
 * @since 1.0.4
 */
fun Calendar.isSameDay(other: Calendar): Boolean {
  return year == other.year
          && month == other.month
          && dayOfMonth == other.dayOfMonth
}