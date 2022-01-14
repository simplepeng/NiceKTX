package me.simple.ktx

fun <A> ifNotNull(
    a: A?,
    block: (A) -> Unit
) {
    if (a != null) block(a)
}

fun <A, B> ifNotNull(
    a: A, b: B,
    block: (arg1: A, arg2: B) -> Unit
) {
    if (a != null && b != null) block(a, b)
}

fun <A, B, C> ifNotNull(
    a: A, b: B, c: C,
    block: (arg1: A, arg2: B, arg3: C) -> Unit
) {
    if (a != null && b != null && c != null) block(a, b, c)
}