package me.simple.ktxdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_coroutine_ktx.*
import me.simple.ktx.launchOnCreate
import me.simple.ktx.launchOnResume
import me.simple.ktx.launchOnStart
import me.simple.ktx.singleClick

class CoroutineKTXActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_ktx)

        btnLaunchOnCreate.singleClick {
            launchOnCreate {

            }
        }

        btnLaunchOnStart.singleClick {
            launchOnStart {

            }
        }

        btnLaunchOnResume.singleClick {
            launchOnResume {

            }
        }
    }
}