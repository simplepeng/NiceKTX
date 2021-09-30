package me.simple.ktx

import android.graphics.*
import android.util.Base64
import ktx.common.Desc
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


@Desc("Bitmap转File", "v1.0.1")
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

@Desc("Bitmap转base64", "v1.0.1", "v1.0.4", "支持flags")
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

@Desc("base64转Bitmap", "v1.0.4")
fun String.toBitmap(flags: Int = Base64.DEFAULT): Bitmap {
    val bytes = Base64.decode(this, flags)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

@Desc("按比例缩放Bitmap", "v1.0.4")
fun Bitmap.scale(
    sx: Float,
    sy: Float,
    filter: Boolean = false
): Bitmap {
    val matrix = Matrix()
    matrix.postScale(sx, sy)
    return Bitmap.createBitmap(this, 0, 0, this.width, this.height, matrix, filter)
}

@Desc("按大小缩放Bitmap", "v1.0.4")
fun Bitmap.scale(
    newWidth: Int,
    newHeight: Int,
    filter: Boolean = false
): Bitmap {
    val sx = newWidth.toFloat() / this.width
    val sy = newHeight.toFloat() / this.height
    return scale(sx, sy, filter)
}

@Desc("添加水印", "v1.0.4")
fun Bitmap.addWatermark(
    watermark: Bitmap,
    x: Float,
    y: Float,
    newWidth: Int = watermark.width,
    newHeight: Int = watermark.height,
    alpha: Int = 255
) {
    val canvas = Canvas(this)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    paint.alpha = alpha
//    canvas.drawBitmap(watermark, x, y, paint)
    val dstRect = RectF(x, y, x + newWidth, y + newHeight)
    canvas.drawBitmap(watermark, null, dstRect, paint)
}