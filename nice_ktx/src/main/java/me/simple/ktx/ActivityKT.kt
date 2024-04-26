package me.simple.ktx

import android.app.Activity
import android.content.Intent
import ktx.common.Desc
import kotlin.reflect.KClass


/**
 * ActivityKT Activity的扩展
 */

/**
 * 启动一个Activity
 * @param clazz 要启动的Activity类
 * @since 1.0.2
 */
@Desc("启动一个Activity", "1.0.2")
inline fun <reified T : Activity> Activity.startActivity(clazz: KClass<T>) {
    this.startActivity(Intent(this, clazz.java))
}