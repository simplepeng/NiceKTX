package me.simple.ktx.viewpager

import androidx.viewpager.widget.ViewPager

/**
 * 是否可以切换到下一页
 *
 * @since 1.0.4
 */
val ViewPager.canNextPage: Boolean
    get() {
        if (adapter == null) return false
        return this.currentItem + 1 < this.adapter!!.count
    }

/**
 * 下一页
 * @param smoothScroll 是否平滑滚动
 * @since 1.0.4
 */
fun ViewPager.nextPage(smoothScroll: Boolean = true) {
    if (this.adapter == null) return
    val nextItem = this.currentItem + 1
    if (nextItem >= adapter!!.count) return
    this.setCurrentItem(nextItem, smoothScroll)
}

/**
 * 是否可以切换到上一页
 *
 * @since 1.0.4
 */
val ViewPager.canPrePage: Boolean
    get() {
        if (adapter == null) return false
        return this.currentItem -1 >= 0
    }

/**
 * 上一页
 * @param smoothScroll 是否平滑滚动
 * @since 1.0.4
 */
fun ViewPager.prePage(smoothScroll: Boolean = true) {
    if (this.adapter == null) return
    val preItem = this.currentItem - 1
    if (preItem < 0) return
    this.setCurrentItem(preItem, smoothScroll)
}