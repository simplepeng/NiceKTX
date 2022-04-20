package me.simple.ktx.viewpager

import androidx.viewpager.widget.ViewPager

fun ViewPager.nextPage(smoothScroll: Boolean = true) {
    if (this.adapter == null) return
    val nextItem = this.currentItem + 1
    if (nextItem >= adapter!!.count) return
    this.setCurrentItem(nextItem, smoothScroll)
}

fun ViewPager.prePage(smoothScroll: Boolean = true) {
    if (this.adapter == null) return
    val preItem = this.currentItem - 1
    if (preItem < 0) return
    this.setCurrentItem(preItem, smoothScroll)
}