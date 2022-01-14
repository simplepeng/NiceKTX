package me.simple.ktx

import ktx.common.Desc

@Desc("", "v1.0.4")
fun Boolean?.ifTrue(block: (Boolean) -> Unit) {
    if (this == true) block(this)
}

@Desc("", "v1.0.4")
fun Boolean?.ifFalse(block: (Boolean) -> Unit) {
    if (this == false) block(this)
}

@Desc("", "v1.0.4")
fun Boolean?.isTrue() = this == true

@Desc("", "v1.0.4")
fun Boolean?.isFalse() = this == false