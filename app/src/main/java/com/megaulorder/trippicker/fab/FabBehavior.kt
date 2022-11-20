package com.megaulorder.trippicker.fab

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat

class FabBehavior @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
) : CoordinatorLayout.Behavior<FabView>(context, attrs) {

	override fun onNestedScroll(
		coordinatorLayout: CoordinatorLayout,
		child: FabView,
		target: View,
		dxConsumed: Int,
		dyConsumed: Int,
		dxUnconsumed: Int,
		dyUnconsumed: Int,
		type: Int,
		consumed: IntArray,
	) {
		super.onNestedScroll(
			coordinatorLayout,
			child,
			target,
			dxConsumed,
			dyConsumed,
			dxUnconsumed,
			dyUnconsumed,
			type,
			consumed
		)

		if (child.shouldIgnoreBehavior) {
			return
		}

		if (dyConsumed > 0 && !child.isVisible()) {
			child.showFab()
		} else if (dyConsumed < 0 && child.isVisible()) {
			child.hideFab()
		}
	}

	override fun onStartNestedScroll(
		coordinatorLayout: CoordinatorLayout,
		child: FabView,
		directTargetChild: View,
		target: View,
		axes: Int,
		type: Int,
	): Boolean = axes == ViewCompat.SCROLL_AXIS_VERTICAL

	private fun View.isVisible(): Boolean = visibility == View.VISIBLE
}