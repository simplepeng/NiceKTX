package me.simple.ktx

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun LifecycleOwner.launchOnCreate(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnCoroutineDestroyObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

class OnCoroutineDestroyObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : LifecycleObserver {

    private var mJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mJob = scope.launch(context, start, block)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mJob?.cancel()
    }
}

fun LifecycleOwner.launchOnStart(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnCoroutineStopObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

class OnCoroutineStopObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : LifecycleObserver {

    private var mJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        mJob = scope.launch(context, start, block)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        mJob?.cancel()
    }
}

fun LifecycleOwner.launchOnResume(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnCoroutinePauseObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

class OnCoroutinePauseObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : LifecycleObserver {

    private var mJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        mJob = scope.launch(context, start, block)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        mJob?.cancel()
    }
}