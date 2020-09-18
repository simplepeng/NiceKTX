package me.simple.ktx

import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun GlobalScope.launchSafe(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    error: (e: Exception) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
) = launch(context, start) {
    try {
        block()
    } catch (e: Exception) {
        error(e)
    }
}
