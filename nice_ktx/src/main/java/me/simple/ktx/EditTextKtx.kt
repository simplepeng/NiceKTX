package me.simple.ktx

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * EditText的文本为空
 */
fun EditText.isEmpty(): Boolean {
    return this.text.isNullOrEmpty()
}

/**
 * 将光标移动至末尾
 */
fun EditText.selectionEnd() {
    this.setSelection(this.text.length)
}

/**
 * 监听文本变化
 */
fun EditText.listenerTextChange(onChange: (s: CharSequence?, count: Int) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onChange(s, count)
        }
    })
}

