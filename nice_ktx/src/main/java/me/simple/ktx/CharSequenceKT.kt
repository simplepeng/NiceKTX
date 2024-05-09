package me.simple.ktx

/**
 * 判断字符串不是null也不是empty
 *
 * @since 1.0.4
 */
fun CharSequence?.isNotNullOrEmpty() = !this.isNullOrEmpty()