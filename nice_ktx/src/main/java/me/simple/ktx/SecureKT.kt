package me.simple.ktx

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.security.DigestInputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

private val HEX_DIGITS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

/**
 * 字符串转MD5
 *
 * @since 1.0.1
 */
val String?.md5: String
    get() {
        if (this.isNullOrEmpty()) return ""
        return encryptMD5ToString(this.toByteArray())
    }

/**
 * @suppress
 */
private fun encryptMD5ToString(data: ByteArray): String {
    return bytes2HexString(encryptMD5(data))
}

/**
 * @suppress
 */
private fun bytes2HexString(bytes: ByteArray?): String {
    if (bytes == null) return ""
    val len = bytes.size
    if (len <= 0) return ""
    val ret = CharArray(len shl 1)
    var i = 0
    var j = 0
    while (i < len) {
        ret[j++] = HEX_DIGITS[bytes[i].toInt() shr 4 and 0x0f]
        ret[j++] = HEX_DIGITS[bytes[i].toInt() and 0x0f]
        i++
    }
    return String(ret)
}

/**
 * @suppress
 */
private fun encryptMD5(data: ByteArray): ByteArray? {
    return hashTemplate(data, "MD5")
}

/**
 * @suppress
 */
private fun hashTemplate(data: ByteArray?, algorithm: String): ByteArray? {
    if (data == null || data.isEmpty()) return null
    return try {
        val md = MessageDigest.getInstance(algorithm)
        md.update(data)
        md.digest()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
        null
    }

}

/**
 * 获取文件的MD5
 *
 * @since 1.0.1
 */
val File?.md5: String
    get() {
        return bytes2HexString(encryptMD5File(this))
    }

/**
 * @suppress
 */
private fun encryptMD5File(file: File?): ByteArray? {
    if (file == null) return null
    var fis: FileInputStream? = null
    val digestInputStream: DigestInputStream
    try {
        fis = FileInputStream(file)
        var md = MessageDigest.getInstance("MD5")
        digestInputStream = DigestInputStream(fis, md)
        val buffer = ByteArray(256 * 1024)
        while (true) {
            if (digestInputStream.read(buffer) <= 0) break
        }
        md = digestInputStream.messageDigest
        return md.digest()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
        return null
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    } finally {
        try {
            fis?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}

/**
 * 字符串转sha1
 *
 * @since 1.0.1
 */
val String.sha1: String
    get() {
        return bytes2HexString(encryptSHA1(this.toByteArray()))
    }

/**
 * @suppress
 */
private fun encryptSHA1(data: ByteArray): ByteArray? {
    return hashTemplate(data, "SHA-1")
}

/**
 * 字符串转sha256
 *
 * @since 1.0.1
 */
val String.sha256: String
    get() {
        return bytes2HexString(encryptSHA256(this.toByteArray()))
    }

/**
 * @suppress
 */
private fun encryptSHA256(data: ByteArray): ByteArray? {
    return hashTemplate(data, "SHA-256")
}

/**
 * 字符串转sha512
 *
 * @since 1.0.1
 */
val String.sha512: String
    get() {
        return bytes2HexString(encryptSHA512(this.toByteArray()))
    }

/**
 * @suppress
 */
private fun encryptSHA512(data: ByteArray): ByteArray? {
    return hashTemplate(data, "SHA-512")
}

