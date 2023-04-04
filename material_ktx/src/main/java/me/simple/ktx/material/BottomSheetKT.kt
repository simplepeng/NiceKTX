package me.simple.ktx.material

import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ktx.common.Desc

@Desc("", "v1.0.4")
fun BottomSheetDialogFragment.getBehavior() = (dialog as? BottomSheetDialog)?.behavior

@Desc("", "v1.0.4")
var BottomSheetDialogFragment.isDraggable: Boolean
    set(value) {
        getBehavior()?.isDraggable = value
    }
    get() = getBehavior()?.isDraggable ?: false

@Desc("", "v1.0.4")
var BottomSheetDialog.isDraggable: Boolean
    set(value) {
        behavior.isDraggable = value
    }
    get() = behavior.isDraggable