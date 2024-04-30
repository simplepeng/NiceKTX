package me.simple.ktx.recyclerview

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * 线性布局
 *
 * @since 1.0.4
 */
fun RecyclerView.linear(
    @RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL,
    reverseLayout: Boolean = false
) {
    this.layoutManager = LinearLayoutManager(context, orientation, reverseLayout)
}

/**
 * 网格布局
 *
 * @since 1.0.4
 */
fun RecyclerView.grid(
    spanCount: Int,
    @RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL,
    reverseLayout: Boolean = false
) {
    this.layoutManager = GridLayoutManager(context, spanCount, orientation, reverseLayout)
}

/**
 * 交错布局
 *
 * @since 1.0.4
 */
fun RecyclerView.staggered(
    spanCount: Int,
    @RecyclerView.Orientation orientation: Int = RecyclerView.VERTICAL
) {
    this.layoutManager = StaggeredGridLayoutManager(spanCount, orientation)
}

/**
 * 删除所有ItemDecoration
 *
 * @since 1.0.4
 */
fun RecyclerView.removeAllItemDecoration() {
    for (index in 0 until itemDecorationCount) {
        removeItemDecorationAt(index)
    }
}

/**
 * 滚动到末尾
 *
 * @since 1.0.4
 */
fun RecyclerView.scrollToEnd(smooth: Boolean = true) {
    val itemCount = adapter?.itemCount ?: 0
    if (itemCount <= 0) return
    if (smooth) {
        this.smoothScrollToPosition(itemCount - 1)
    } else {
        this.scrollToPosition(itemCount - 1)
    }
}

/**
 * 滚动到开始
 *
 * @since 1.0.4
 */
fun RecyclerView.scrollToStart(smooth: Boolean = true) {
    val itemCount = adapter?.itemCount ?: 0
    if (itemCount <= 0) return
    if (smooth) {
        this.smoothScrollToPosition(0)
    } else {
        this.scrollToPosition(0)
    }
}