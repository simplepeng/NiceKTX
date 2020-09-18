package me.simple.ktx

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import java.lang.Exception

fun LifecycleCoroutineScope.launchSafeWhenCreated(
    error: (e: Exception) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
) = launchWhenCreated {
    try {
        withContext(Dispatchers.IO, block)
    } catch (e: Exception) {
        withContext(Dispatchers.Main) {
            error.invoke(e)
        }
    }
}

fun LifecycleCoroutineScope.launchSafeWhenStarted(
    onError: (e: java.lang.Exception) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
): Job {
    return this.launchWhenStarted {
        try {
            block.invoke(this)
        } catch (e: java.lang.Exception) {
            onError.invoke(e)
        }
    }
}

fun LifecycleCoroutineScope.launchSafeWhenResumed(
    onError: (e: java.lang.Exception) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
): Job {
    return this.launchWhenResumed {
        try {
            block.invoke(this)
        } catch (e: java.lang.Exception) {
            onError.invoke(e)
        }
    }
}