package me.simple.ktx

import ktx.common.Desc

@Desc("布尔值的默认值填充", "v1.0.4")
fun Boolean?.orDefault(defValue: Boolean = true): Boolean {
    return this ?: defValue
}

@Desc("字符串的默认值填充", "v1.0.4")
fun String?.orDefault(defValue: String = ""): String {
    return this ?: defValue
}

@Desc("数值类型的默认值填充", "v1.0.4")
fun <T : Number> T?.orDefault(defValue: T): T {
    return this ?: defValue
}

@Desc("默认值填充", "v1.0.4")
fun <T> T?.orDefault(defValue: T): T {
    return this ?: defValue
}



