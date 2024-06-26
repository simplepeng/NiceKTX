package me.simple.ktx

import android.app.Activity
import android.content.Intent
import kotlin.reflect.KClass


/**
 * ActivityKT Activity的扩展
 */

/**
 * 启动一个Activity
 *
 * @param clazz 要启动的Activity类
 * @since 1.0.2
 */
inline fun <reified T : Activity> Activity.startActivity(clazz: KClass<T>) {
    this.startActivity(Intent(this, clazz.java))
}