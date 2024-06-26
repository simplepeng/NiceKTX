package me.simple.ktx.eventbus

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import org.greenrobot.eventbus.EventBus

/**
 * 在onCreate中注册事件，自动在onDestroy中注销事件
 *
 * @param owner LifecycleOwner，可以是Activity或Fragment
 */
fun <T : LifecycleOwner> EventBus.registerOnCreate(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnCreateLifecycleObserver(this, owner))
}

/**
 * @suppress
 */
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

/**
 * 在onStart中注册事件，自动在onStop中注销事件
 *
 * @param owner LifecycleOwner，可以是Activity或Fragment
 */
fun <T : LifecycleOwner> EventBus.registerOnStart(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnStartLifecycleObserver(this, owner))
}

/**
 * @suppress
 */
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

/**
 * 在onResume中注册事件，自动在onPause中注销事件
 *
 * @param owner LifecycleOwner，可以是Activity或Fragment
 */
fun <T : LifecycleOwner> EventBus.registerOnResume(owner: T) {
    if (this.isRegistered(owner)) return
    owner.lifecycle.addObserver(OnResumeLifecycleObserver(this, owner))
}

/**
 * @suppress
 */
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

/**
 * 安全的调用注册方法
 */
fun EventBus.safeRegister(obj: Any) {
    if (this.isRegistered(obj)) return
    this.register(obj)
}

/**
 * 安全的调用注销方法
 */
fun EventBus.safeUnregister(obj: Any) {
    if (!this.isRegistered(obj)) return
    this.unregister(obj)
}

/**
 * 发布事件
 */
fun postEvent(event: Any) = EventBus.getDefault().post(event)

/**
 * 发布粘性事件
 */
fun postStickyEvent(event: Any) = EventBus.getDefault().postSticky(event)