package me.simple.ktx

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

const val TAG = "CoroutineKTX.kt"

fun LifecycleOwner.launchOnCreate(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnDestroyLifecycleObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

class OnDestroyLifecycleObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : LifecycleObserver {

    private var mJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(TAG, "onCreate")
        mJob = scope.launch(context, start, block)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(TAG, "onDestroy")
        mJob?.cancel()
    }
}

fun LifecycleOwner.launchOnStart(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnStopLifecycleObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

class OnStopLifecycleObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : LifecycleObserver {

    private var mJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d(TAG, "onStart")
        mJob = scope.launch(context, start, block)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(TAG, "onStop")
        mJob?.cancel()
    }
}

fun LifecycleOwner.launchOnResume(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) {
    val observer = OnPauseLifecycleObserver(this.lifecycleScope, context, start, block)
    this.lifecycle.addObserver(observer)
}

class OnPauseLifecycleObserver(
    private val scope: LifecycleCoroutineScope,
    private val context: CoroutineContext = EmptyCoroutineContext,
    private val start: CoroutineStart = CoroutineStart.DEFAULT,
    private val block: suspend CoroutineScope.() -> Unit
) : LifecycleObserver {

    private var mJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(TAG, "onResume")
        mJob = scope.launch(context, start, block)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(TAG, "onPause")
        mJob?.cancel()
    }
}