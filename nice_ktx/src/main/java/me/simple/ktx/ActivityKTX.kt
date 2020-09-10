package me.simple.ktx

import android.app.Activity
import android.content.Intent
import kotlin.reflect.KClass

inline fun <reified T : Activity> Activity.startActivity(clazz: KClass<T>) {
    this.startActivity(Intent(this, clazz.java))
}