package com.megaulorder.trippicker.fab

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.megaulorder.trippicker.R

class FabView @JvmOverloads constructor(
	context: Context,
	attributeSet: AttributeSet? = null,
	defStyleAttr: Int = 0,
) : LinearLayout(context, attributeSet, defStyleAttr),
	CoordinatorLayout.AttachedBehavior {

	var shouldIgnoreBehavior: Boolean = false

	private val behavior = FabBehavior(context, attributeSet)

	init {
		inflate(context, R.layout.fab_layout, this)
	}

	override fun getBehavior(): CoordinatorLayout.Behavior<FabView> = behavior

	fun showFab() {
		if (isVisible()) {
			return
		} else {
			visibility = View.VISIBLE
		}
	}

	fun hideFab() {
		if (!isVisible()) {
			return
		} else {
			visibility = View.INVISIBLE
		}
	}

	private fun isVisible(): Boolean = visibility == View.VISIBLE
}