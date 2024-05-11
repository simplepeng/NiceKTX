package me.simple.ktx

/**
 * @since 1.0.4
 */
fun Boolean?.ifTrue(block: (Boolean) -> Unit) {
    if (this == true) block(this)
}

/**
 * @since 1.0.4
 */
fun Boolean?.ifFalse(block: (Boolean) -> Unit) {
    if (this == false) block(this)
}

/**
 * 是否为 true
 *
 * @since 1.0.4
 */
val Boolean?.isTure: Boolean
    get() = this == true

/**
 * 是否为 false
 *
 * @since 1.0.4
 */
val Boolean?.isFalse
    get() = this == false