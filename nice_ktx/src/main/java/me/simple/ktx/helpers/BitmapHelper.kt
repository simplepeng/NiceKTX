package me.simple.ktx.helpers

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable

/**
 * @suppress
 */
object BitmapHelper {

    fun scaleBitmap(
        res: Resources,
        resId: Int,
        inSampleSize: Int = 2
    ): Bitmap {
        val options = BitmapFactory.Options()
        options.inSampleSize = inSampleSize
        return BitmapFactory.decodeResource(res, resId, options)
    }

    fun scaleBitmapDrawable(
        res: Resources,
        resId: Int,
        inSampleSize: Int = 2
    ): BitmapDrawable {
        val bm = scaleBitmap(res, resId, inSampleSize)
        return BitmapDrawable(res, bm)
    }
}