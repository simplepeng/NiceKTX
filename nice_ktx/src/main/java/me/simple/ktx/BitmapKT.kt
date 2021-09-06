package me.simple.ktx

import android.graphics.Bitmap
import android.graphics.BitmapFactory
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

@Desc("Bitmap转base64", "v1.0.1")
fun Bitmap.base64(
    quality: Int = 100,
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG
): String {
    val bos = ByteArrayOutputStream()
    this.compress(format, quality, bos)
    val bytes = bos.toByteArray()

    val encode = Base64.encode(bytes, Base64.DEFAULT)
    return String(encode)
}

@Desc("base64转Bitmap", "v1.0.4")
fun String.toBitmap(flags: Int = Base64.DEFAULT): Bitmap {
    val bytes = Base64.decode(this, flags)
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}