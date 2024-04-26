package me.simple.ktx.viewpager

import androidx.viewpager2.widget.ViewPager2
import ktx.common.Desc

/**
 * 下一页
 * @param smoothScroll 是否平滑滚动
 * @since 1.0.4
 */
fun ViewPager2.nextPage(smoothScroll: Boolean = true) {
  if (this.adapter == null) return
  val nextItem = this.currentItem + 1
  if (nextItem >= this.adapter!!.itemCount) return
  this.setCurrentItem(nextItem, smoothScroll)
}

/**
 * 上一页
 * @param smoothScroll 是否平滑滚动
 * @since 1.0.4
 */
fun ViewPager2.prePage(smoothScroll: Boolean = true) {
  if (this.adapter == null) return
  val preItem = this.currentItem - 1
  if (preItem < 0) return
  this.setCurrentItem(preItem, smoothScroll)
}