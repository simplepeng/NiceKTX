package me.simple.ktx.coroutine

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 自动在onDestroy取消Job
 *
 * @since 1.0.4
 */
fun LifecycleOwner.launchOnCreate(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnCoroutineDestroyObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

/**
 * @suppress
 */
class OnCoroutineDestroyObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : DefaultLifecycleObserver {

    private var mJob: Job? = null

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        mJob = scope.launch(context, start, block)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        mJob?.cancel()
    }
}

/**
 * 自动在onStop取消Job
 *
 * @since 1.0.4
 */
fun LifecycleOwner.launchOnStart(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnCoroutineStopObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

/**
 * @suppress
 */
class OnCoroutineStopObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : DefaultLifecycleObserver {

    private var mJob: Job? = null

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        mJob = scope.launch(context, start, block)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        mJob?.cancel()
    }
}

/**
 * 自动在onPause取消Job
 *
 * @since 1.0.4
 */
fun LifecycleOwner.launchOnResume(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnCoroutinePauseObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

/**
 * @suppress
 */
class OnCoroutinePauseObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : DefaultLifecycleObserver {

    private var mJob: Job? = null

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        mJob = scope.launch(context, start, block)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        mJob?.cancel()
    }
}