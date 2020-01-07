package me.simple.ktxdemo

import android.app.Application
import me.simple.ktx.NiceKtx

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()


        NiceKtx.init().setLogTag("DemoApp")
    }
}