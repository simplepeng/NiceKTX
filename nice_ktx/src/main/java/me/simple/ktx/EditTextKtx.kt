package me.simple.ktx

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.StringRes

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
 * 设置文字，并将将光标移动至末尾
 */
fun EditText.setTextAndSelectionEnd(@StringRes resId: Int) {
    this.setText(resId)
    selectionEnd()
}

/**
 * 设置文字，并将将光标移动至末尾
 */
fun EditText.setTextAndSelectionEnd(text: CharSequence) {
    this.setText(text)
    selectionEnd()
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

