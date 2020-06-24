package me.simple.ktx

import android.widget.EditText

fun EditText.textIsNullOrEmpty(): Boolean {
    return this.text.isNullOrEmpty()
}

