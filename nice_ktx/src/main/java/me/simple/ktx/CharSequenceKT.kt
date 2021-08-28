package me.simple.ktx

import ktx.common.Desc

@Desc("判断字符串不是null也不是empty","v1.0.2")
fun CharSequence?.isNotNullAndEmpty() = !this.isNullOrEmpty()