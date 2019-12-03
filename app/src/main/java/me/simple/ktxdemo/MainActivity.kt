package me.simple.ktxdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import me.simple.ktx.longToast
import me.simple.ktx.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun toast(view: View) {
        longToast(R.string.app_name)
    }
}
