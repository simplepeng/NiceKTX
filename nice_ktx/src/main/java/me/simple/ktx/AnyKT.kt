package me.simple.ktx

import ktx.common.Desc

@Desc("判断对象是否为空", "1.0.1")
fun Any?.isNull() = this == null

@Desc("判断对象是否为空", "1.0.1")
fun Any?.isNotNull() = this != null

