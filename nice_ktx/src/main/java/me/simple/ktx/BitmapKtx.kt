package me.simple.ktx

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

fun Bitmap.saveFile(
    path: String,
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
    quality: Int = 100,
    onError: (e: Exception) -> Unit = {}
) {
    try {
        val file = File(path)
        val out = FileOutputStream(file)
        this.compress(format, quality, out)
        out.flush()
        out.close()
    } catch (e: Exception) {
        onError.invoke(e)
    }
}

fun Bitmap.base64(
    quality: Int = 100,
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG,
    onError: (e: Exception) -> Unit = {}
): String? {
    try {
        val bos = ByteArrayOutputStream()
        this.compress(format, quality, bos)
        val bytes = bos.toByteArray()

        val encode = Base64.encode(bytes, Base64.DEFAULT)
        return String(encode)
    } catch (e: Exception) {
        onError.invoke(e)
    }
    return null
}