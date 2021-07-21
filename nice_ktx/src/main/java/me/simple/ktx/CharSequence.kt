package me.simple.ktx

/**
 * 判断字符串不是null也不是empty
 * create-v1.0.2
 */
fun CharSequence?.isNotNullAndEmpty() = !this.isNullOrEmpty()