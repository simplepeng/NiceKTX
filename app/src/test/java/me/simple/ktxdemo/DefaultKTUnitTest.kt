package me.simple.ktxdemo

import me.simple.ktx.orDefault
import org.junit.Test

class DefaultKTUnitTest {

    @Test
    fun allTest() {

        val bool: Boolean? = null
        println("bool = ${bool.orDefault(false)}")
        bool?.let {  }

        val str: String? = null
        println("str = ${str.orDefault("haha")}")

        val intVale: Int? = null
        println("intVale = ${intVale.orDefault(1)}")

        val floatVale: Float? = null
        println("floatVale = ${floatVale.orDefault(2)}")
    }
}