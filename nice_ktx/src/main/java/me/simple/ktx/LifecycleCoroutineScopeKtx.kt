package me.simple.ktx

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

fun LifecycleCoroutineScope.launchSafeWhenCreated(
    onError: (e: java.lang.Exception) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
): Job {
    return this.launchWhenCreated {
        try {
            block.invoke(this)
        } catch (e: java.lang.Exception) {
            onError.invoke(e)
        }
    }
}

fun LifecycleCoroutineScope.launchSafeWhenStarted(
    onError: (e: java.lang.Exception) -> Unit = {},
    block: suspend CoroutineScope.() -> Unit
): Job {
    return this.launchWhenStarted{
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
    return this.launchWhenResumed{
        try {
            block.invoke(this)
        } catch (e: java.lang.Exception) {
            onError.invoke(e)
        }
    }
}