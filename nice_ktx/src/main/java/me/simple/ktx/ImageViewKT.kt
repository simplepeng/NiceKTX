package me.simple.ktx

import android.widget.ImageView
import me.simple.ktx.helpers.BitmapHelper

/**
 * 设置缩放的资源图
 *
 * @param resId 资源id
 * @param inSampleSize 缩放比例
 *
 * @since 1.0.2
 */
fun ImageView.setScaleImageResource(
    resId: Int,
    inSampleSize: Int = 2
) {
    val scaleBitmap = BitmapHelper.scaleBitmap(this.resources, resId, inSampleSize)
    this.setImageBitmap(scaleBitmap)
}