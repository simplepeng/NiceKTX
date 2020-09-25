package me.simple.ktxdemo

import android.os.Bundle
import com.blankj.utilcode.util.ClickUtils
import kotlinx.android.synthetic.main.activity_view_ktx.*

class ViewKtxActivity : BaseActivity() {

    private val TAG = "ViewKtxActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_ktx)

        debounceClick()
    }

    private fun debounceClick() {
//        btn_debounce.setOnDebounceClickListener {
//            logDebug(TAG, "debounceClick")
//        }

        ClickUtils.applySingleDebouncing(btn_debounce) {
        }
    }
}