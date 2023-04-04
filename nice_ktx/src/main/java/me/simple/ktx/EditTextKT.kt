package me.simple.ktx

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.StringRes
import ktx.common.Desc

@Desc("判断EditText的文本是否为空","v1.0.4")
fun EditText.isEmpty(): Boolean {
    return this.text.isNullOrEmpty()
}

@Desc("将光标移动至末尾","v1.0.4")
fun EditText.selectionEnd() {
    this.setSelection(this.text.length)
}

@Desc("设置文字，并将将光标移动至末尾","v1.0.4")
fun EditText.setTextAndSelectionEnd(@StringRes resId: Int) {
    this.setText(resId)
    selectionEnd()
}

@Desc("设置文字，并将将光标移动至末尾","v1.0.4")
fun EditText.setTextAndSelectionEnd(text: CharSequence) {
    this.setText(text)
    selectionEnd()
}

@Desc("监听文本变化","v1.0.4")
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

