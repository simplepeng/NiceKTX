package me.simple.ktx

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.StringRes
import androidx.core.widget.addTextChangedListener

/**
 * 判断EditText的文本是否为空
 *
 * @since 1.0.4
 */
fun EditText.isEmpty(): Boolean {
    return this.text.isNullOrEmpty()
}

/**
 * 将光标移动至末尾
 *
 * @since 1.0.4
 */
fun EditText.setSelectionToEnd() {
    this.setSelection(this.text.length)
}

/**
 * 设置文字，并将将光标移动至末尾
 *
 * @since 1.0.4
 */
fun EditText.setTextAndSelectionToEnd(@StringRes resId: Int) {
    this.setText(resId)
    setSelectionToEnd()
}

/**
 * 设置文字，并将将光标移动至末尾
 *
 * @since 1.0.4
 */
fun EditText.setTextAndSelectionToEnd(text: CharSequence) {
    this.setText(text)
    setSelectionToEnd()
}

/**
 * 监听文本变化
 *
 * @since 1.0.4
 */
@Deprecated("ktx TextViewKT自带了addTextChangedListener方法了")
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

