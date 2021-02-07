package me.simple.ktxdemo

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_view_ktx.*
import me.simple.ktx.*

class ViewKTXActivity : BaseActivity() {

    private var mClickNum = 1

    companion object {
        private const val TAG = "ViewKtxActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_ktx)

        initView()

        btnSingleClick.singleClick {
            val startTime = System.currentTimeMillis()
            val endTime = System.currentTimeMillis()
            Log.d(TAG, "clickTime = $startTime")
            btnSingleClick.text = (mClickNum++).toString()
        }
    }

    private fun initView() {
        initShapes()
    }

    private fun initShapes() {
        btnRoundRect.roundRect(10f.dp, Color.BLACK)
        btnHalfRoundRect.halfRoundRect(Color.RED)

        btnShape.shape(14f.dp, Color.BLUE)
        btnShape2.shape(14f.dp, Color.BLUE, 2.dp, Color.GREEN)
        btnShape3.shape(14f.dp, Color.BLUE, 2.dp, Color.GREEN, 5f.dp, 3f.dp)
        btnShape4.shape(14f.dp, Color.BLUE, 2.dp, Color.GREEN, 5f.dp, 3f.dp, Shape.OVAL)
        btnShape5.shape(10f.dp, 0f, 0f, 15f.dp, Color.RED)

        //渐变
        btnGradientShape1.gradientShape(intArrayOf(Color.RED, Color.GREEN))
        btnGradientShape2.gradientShape(
            intArrayOf(
                Color.YELLOW,
                Color.RED,
                Color.GREEN
            ),
            shape = Shape.OVAL,
            orientation = GradientDrawable.Orientation.RIGHT_LEFT,
            gradientType = GradientDrawable.SWEEP_GRADIENT
        )
        btnGradientShape3.gradientShape(15f.dp, intArrayOf(Color.RED, Color.GREEN))
        btnGradientShape4.gradientShape(15f.dp, 0f, 0f, 15f.dp, intArrayOf(Color.RED, Color.GREEN))
        btnGradientShape5.halfGradientShape(intArrayOf(Color.BLUE, Color.WHITE))
    }
}