package com.megaulorder.trippicker.fab

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FabWidget(
	private val fab: FabView,
	list: RecyclerView,
	private val startVisibilityThreshold: Int = 4,
) {

	var onClickListener: (() -> Unit)? = null

	init {
		fab.hideFab()
		fab.setOnClickListener {
			onClickListener?.invoke()
		}
		list.addOnScrollListener(
			object : RecyclerView.OnScrollListener() {

				override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
					val layoutManager: LinearLayoutManager? =
						recyclerView.layoutManager as? LinearLayoutManager?
					val firstVisibleItemPosition: Int =
						layoutManager?.findFirstVisibleItemPosition() ?: return

					if (firstVisibleItemPosition <= startVisibilityThreshold) {
						hideFab()
						fab.shouldIgnoreBehavior = true
					} else {
						fab.shouldIgnoreBehavior = false
					}
				}
			}
		)
	}

	private fun hideFab() {
		fab.hideFab()
	}
}
