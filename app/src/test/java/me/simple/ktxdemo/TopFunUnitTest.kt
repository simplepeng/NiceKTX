package me.simple.ktxdemo

import me.simple.ktx.ifNotNull
import org.junit.Test

class TopFunUnitTest {

    @Test
    fun allTest() {
        println("TopFunUnitTest -------- allTest")

        val a: String? = "hello"
        ifNotNull(a) {
            println("ifNotNull(a) -- $a")
        }

        val b: Boolean? = true
        ifNotNull(a, b) { arg1, arg2 ->
            println("ifNotNull(a,b) -- $arg1,$arg2")
        }

        val c: Float? = 1.1f
        ifNotNull(a, b, c) { arg1, arg2, arg3 ->
            println("ifNotNull(a,b,c) -- $arg1,$arg2,$arg3")
        }
    }
}