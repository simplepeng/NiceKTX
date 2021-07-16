package me.simple.ktx

import android.widget.ImageView
import ktx.common.Desc
import me.simple.ktx.helpers.BitmapHelper

@Desc("设置缩放的资源图", "1.0.2")
fun ImageView.setScaleImageResource(
    resId: Int,
    inSampleSize: Int = 2
) {
    val scaleBitmap = BitmapHelper.scaleBitmap(this.resources, resId, inSampleSize)
    this.setImageBitmap(scaleBitmap)
}