package me.simple.ktx

import java.util.Calendar

var Calendar.year: Int
  get() = get(Calendar.YEAR)
  set(value) = set(Calendar.YEAR, value)

var Calendar.month: Int
  get() = get(Calendar.MONTH) + 1
  set(value) = set(Calendar.MONTH, value - 1)

var Calendar.day: Int
  get() = get(Calendar.DAY_OF_MONTH)
  set(value) = set(Calendar.DAY_OF_MONTH, value)