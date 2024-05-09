package me.simple.ktx

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * 这是Bitmap的扩展
 * @author simplepeng
 * @since 1.0.1
 */


/**
 * 保存到文件
 *
 * @param path 保存路径
 * @param format 保存格式
 * @param quality 保存质量
 *
 * @since 1.0.1
 */
fun Bitmap.saveFile(
    path: String,
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
    quality: Int = 100
) {
    val file = File(path)
    val out = FileOutputStream(file)
    this.compress(format, quality, out)
    out.flush()
    out.close()
}

/**
 * Bitmap转base64
 *
 * @param quality 保存质量
 * @param format 保存格式
 * @param flags 标志位
 *
 * @since 1.0.1
 */
fun Bitmap.base64(
    quality: Int = 100,
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
    flags: Int = Base64.DEFAULT
): String {
    val bos = ByteArrayOutputStream()
    this.compress(format, quality, bos)
    val bytes = bos.toByteArray()

    val encode = Base64.encode(bytes, flags)
    return String(encode)
}

/**
 * base64转Bitmap
 *
 * @param flags 标志位
 *
 * @since 1.0.4
 */
fun String.toBitmap(
    flags: Int = Base64.DEFAULT
): Bitmap {
    val bytes = Base64.decode(this, flags)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

/**
 * 按比例缩放Bitmap
 *
 * @param sx 缩放比例
 * @param sy 缩放比例
 * @param filter
 *
 * @since 1.0.4
 */
fun Bitmap.scale(
    sx: Float,
    sy: Float,
    filter: Boolean = false
): Bitmap {
    val matrix = Matrix()
    matrix.postScale(sx, sy)
    return Bitmap.createBitmap(this, 0, 0, this.width, this.height, matrix, filter)
}

/**
 * 按大小缩放Bitmap
 *
 * @param newWidth 缩放后的宽
 * @param newHeight 缩放后的高
 *
 * @since 1.0.4
 */
fun Bitmap.scale(
    newWidth: Int,
    newHeight: Int,
    filter: Boolean = false
): Bitmap {
    val sx = newWidth.toFloat() / this.width
    val sy = newHeight.toFloat() / this.height
    return scale(sx, sy, filter)
}

/**
 * 给Bitmap添加水印
 *
 * @param watermark 水印Bitmap
 * @param x 水印x坐标
 * @param y 水印y坐标
 * @param markW 水印宽
 * @param markH 水印高
 * @param alpha 水印透明度
 *
 * @since 1.0.4
 */
fun Bitmap.addWatermark(
    watermark: Bitmap,
    x: Float,
    y: Float,
    markW: Int = watermark.width,
    markH: Int = watermark.height,
    alpha: Int = 255
) {
    val canvas = Canvas(this)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    paint.alpha = alpha
//    canvas.drawBitmap(watermark, x, y, paint)
    val dstRect = RectF(x, y, x + markW, y + markH)
    canvas.drawBitmap(watermark, null, dstRect, paint)
}