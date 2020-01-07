package me.simple.ktx

class NiceKtx private constructor() {

    fun setLogTag(tag: String): NiceKtx {
        logTag = tag
        return this
    }

    companion object {

        var logTag: String = "NiceKtx"

        /**
         *
         */
        fun init(): NiceKtx {
            return NiceKtx()
        }

    }
}