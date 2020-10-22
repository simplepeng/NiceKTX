package me.simple.ktxdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.simple.ktx.safeRegister
import me.simple.ktx.safeUnregister
import org.greenrobot.eventbus.EventBus

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
}
