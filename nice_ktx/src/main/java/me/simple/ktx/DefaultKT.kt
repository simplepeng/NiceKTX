package me.simple.ktx


/**
 * 布尔值的默认值填充
 *
 * @since 1.0.4
 */
fun Boolean?.orDefault(defValue: Boolean = true): Boolean {
    return this ?: defValue
}

/**
 * 字符串的默认值填充
 *
 * @since 1.0.4
 */
fun String?.orDefault(defValue: String = ""): String {
    return this ?: defValue
}

/**
 * 数值类型的默认值填充
 *
 * @since 1.0.4
 */
fun <T : Number> T?.orDefault(defValue: T): T {
    return this ?: defValue
}

/**
 * 默认值填充
 *
 * @since 1.0.4
 */
fun <T> T?.orDefault(defValue: T): T {
    return this ?: defValue
}



