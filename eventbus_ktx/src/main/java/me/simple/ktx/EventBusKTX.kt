package me.simple.ktx

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import org.greenrobot.eventbus.EventBus

/**
 * 在onCreate中注册事件，自动在onDestroy中注销事件
 */
fun <T : LifecycleOwner> EventBus.registerOnCreate(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnCreateLifecycleObserver(this, owner))
}

class OnCreateLifecycleObserver<T>(
    private val eventBus: EventBus,
    private val owner: T
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        if (eventBus.isRegistered(owner)) return
        eventBus.register(owner)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        if (!eventBus.isRegistered(owner)) return
        eventBus.unregister(owner)
    }
}

/**
 * 在onStart中注册事件，自动在onStop中注销事件
 */
fun <T : LifecycleOwner> EventBus.registerOnStart(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnStartLifecycleObserver(this, owner))
}

class OnStartLifecycleObserver<T>(
    private val eventBus: EventBus,
    private val owner: T
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        if (eventBus.isRegistered(owner)) return
        eventBus.register(owner)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        if (!eventBus.isRegistered(owner)) return
        eventBus.unregister(owner)
    }
}

/**
 * 在onResume中注册事件，自动在onPause中注销事件
 */
fun <T : LifecycleOwner> EventBus.registerOnResume(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnResumeLifecycleObserver(this, owner))
}

class OnResumeLifecycleObserver<T>(
    private val eventBus: EventBus,
    private val owner: T
) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        if (eventBus.isRegistered(owner)) return
        eventBus.register(owner)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        if (!eventBus.isRegistered(owner)) return
        eventBus.unregister(owner)
    }
}