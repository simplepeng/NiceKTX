package me.simple.ktx.eventbus

import androidx.lifecycle.*
import ktx.common.Desc
import org.greenrobot.eventbus.EventBus

@Desc("在onCreate中注册事件，自动在onDestroy中注销事件")
fun <T : LifecycleOwner> EventBus.registerOnCreate(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnCreateLifecycleObserver(this, owner))
}

class OnCreateLifecycleObserver<T>(
    private val eventBus: EventBus,
    private val owner: T
) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        if (eventBus.isRegistered(owner)) return
        eventBus.register(owner)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        if (!eventBus.isRegistered(owner)) return
        eventBus.unregister(owner)
    }
}

@Desc("在onStart中注册事件，自动在onStop中注销事件")
fun <T : LifecycleOwner> EventBus.registerOnStart(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnStartLifecycleObserver(this, owner))
}

class OnStartLifecycleObserver<T>(
    private val eventBus: EventBus,
    private val owner: T
) : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if (eventBus.isRegistered(owner)) return
        eventBus.register(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        if (!eventBus.isRegistered(owner)) return
        eventBus.unregister(owner)
    }
}

@Desc("在onResume中注册事件，自动在onPause中注销事件")
fun <T : LifecycleOwner> EventBus.registerOnResume(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnResumeLifecycleObserver(this, owner))
}

class OnResumeLifecycleObserver<T>(
    private val eventBus: EventBus,
    private val owner: T
) : DefaultLifecycleObserver {

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        if (eventBus.isRegistered(owner)) return
        eventBus.register(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        if (!eventBus.isRegistered(owner)) return
        eventBus.unregister(owner)
    }
}

@Desc("安全调用注册方法")
fun EventBus.safeRegister(obj: Any) {
    if (this.isRegistered(obj)) return
    this.register(obj)
}

@Desc("安全调用注销方法")
fun EventBus.safeUnregister(obj: Any) {
    if (!this.isRegistered(obj)) return
    this.unregister(obj)
}

@Desc("发布事件")
fun postEvent(event: Any) = EventBus.getDefault().post(event)

@Desc("发布粘性事件")
fun postStickyEvent(event: Any) = EventBus.getDefault().postSticky(event)