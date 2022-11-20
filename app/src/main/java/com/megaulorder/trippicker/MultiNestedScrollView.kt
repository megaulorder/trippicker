package com.megaulorder.trippicker

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ScrollingView
import androidx.core.widget.NestedScrollView

class MultiNestedScrollView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : NestedScrollView(context, attrs, defStyleAttr) {

	private var scrollableViews: MutableList<View>? = null
	private var currentTouchingScrollableView: View? = null
	private var rect = Rect()

	override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
		super.onLayout(changed, l, t, r, b)

		if (scrollableViews == null) {
			scrollableViews = ArrayList()
			fillScrollableViews()
		}
	}

	override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
		currentTouchingScrollableView = null

		scrollableViews?.let { list ->
			for (view: View in list) {
				view.getGlobalVisibleRect(rect)
				if (rect.contains(event.rawX.toInt(), event.rawY.toInt())) {
					currentTouchingScrollableView = view
					break
				}
			}
		}

		return super.onInterceptTouchEvent(event)
	}

	override fun canScrollVertically(direction: Int): Boolean {
		currentTouchingScrollableView?.let { it ->
			return it.canScrollVertically(direction)
		}
		return super.canScrollVertically(direction)
	}

	private fun fillScrollableViews() {
		for (i in 0 until childCount) {
			fillInternalScrollableViews(getChildAt(i))
		}
	}

	private fun fillInternalScrollableViews(view: View) {
		if (view.isScrollableView()) {
			scrollableViews!!.add(view)
			return
		}

		if (view is ViewGroup) {
			for (i in 0 until view.childCount) {
				fillInternalScrollableViews(view.getChildAt(i))
			}
		}
	}

	private fun View.isScrollableView(): Boolean {
		return this is ScrollingView
	}
}
