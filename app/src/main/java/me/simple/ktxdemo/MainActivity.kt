package me.simple.ktxdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import me.simple.ktx.safeRegister
import me.simple.ktx.safeUnregister
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
    }

    private fun setListener() {
        EventBus.getDefault().safeRegister(this)
        EventBus.getDefault().safeUnregister(this)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnViewKTX -> {
                startTo(ViewKTXActivity::class)
            }
            R.id.btnCoroutineKTX -> {
                startTo(CoroutineKTXActivity::class)
            }
        }
    }

    private fun <T : Activity> startTo(clazz: KClass<T>) {
        val intent = Intent(this, clazz.java)
        startActivity(intent)
    }

    @Subscribe
    fun onEvent(tag: String) {

    }
}
