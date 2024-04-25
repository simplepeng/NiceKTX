package me.simple.ktx.material

import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ktx.common.Desc

/**
 * 获取BottomSheetDialogFragment的Behavior
 * @since 1.0.4
 */
val BottomSheetDialogFragment.behavior
  get() = (dialog as? BottomSheetDialog)?.behavior

/**
 * 设置BottomSheetDialogFragment的是否可以拖拽
 * @since 1.0.4
 */
@Desc("", "v1.0.4")
var BottomSheetDialogFragment.isDraggable: Boolean
  set(value) {
    behavior?.isDraggable = value
  }
  get() = behavior?.isDraggable ?: false

/**
 * 设置BottomSheetDialog的是否可以拖拽
 * @since 1.0.4
 */
@Desc("", "v1.0.4")
var BottomSheetDialog.isDraggable: Boolean
  set(value) {
    behavior.isDraggable = value
  }
  get() = behavior.isDraggable