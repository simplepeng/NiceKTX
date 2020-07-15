package me.simple.ktxdemo

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import me.simple.ktx.openWeb
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContextKtxTest {

    @Test
    fun testOpenWeb() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        appContext.openWeb("https://www.baidu.com")
    }
}