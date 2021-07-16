package me.simple.ktx

import android.app.Activity
import android.content.Intent
import ktx.common.Desc
import kotlin.reflect.KClass

@Desc("启动一个Activity","1.0.2")
inline fun <reified T : Activity> Activity.startActivity(clazz: KClass<T>) {
    this.startActivity(Intent(this, clazz.java))
}