package me.simple.ktx

import android.widget.SeekBar

/**
 * SeekBar.setOnSeekBarChangeListener的扩展函数
 *
 * @since 1.0.4
 */
fun SeekBar.onSeekBarChange(
    onProgressChanged: (seekBar: SeekBar, progress: Int, fromUser: Boolean) -> Unit,
    onStartTrackingTouch: (seekBar: SeekBar) -> Unit = {},
    onStopTrackingTouch: (seekBar: SeekBar) -> Unit = {}
) {
    setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            onProgressChanged(seekBar, progress, fromUser)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            onStartTrackingTouch(seekBar)
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            onStopTrackingTouch(seekBar)
        }
    })
}