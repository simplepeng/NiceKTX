package me.simple.ktxdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.simple.ktx.coroutine.launchOnCreate
import me.simple.ktx.coroutine.launchOnResume
import me.simple.ktx.coroutine.launchOnStart
import me.simple.ktx.singleClick
import me.simple.ktxdemo.databinding.ActivityCoroutineKtxBinding

class CoroutineKTXActivity : AppCompatActivity() {

    private val mBinding by lazy { ActivityCoroutineKtxBinding.inflate(this.layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mBinding.btnLaunchOnCreate.singleClick {
            launchOnCreate {

            }
        }

        mBinding.btnLaunchOnStart.singleClick {
            launchOnStart {

            }
        }

        mBinding.btnLaunchOnResume.singleClick {
            launchOnResume {

            }
        }
    }
}