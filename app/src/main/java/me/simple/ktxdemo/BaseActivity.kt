package me.simple.ktxdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.simple.ktx.orDefault

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}