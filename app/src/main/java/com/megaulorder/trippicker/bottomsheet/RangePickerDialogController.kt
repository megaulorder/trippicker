package com.megaulorder.trippicker.bottomsheet

import com.megaulorder.trippicker.PickerAdapter

class RangePickerDialogController(private val widget: RangePickerDialogWidget) {

	var applyListener: ((selectedMinValue: String?, selectedMaxValue: String?) -> Unit)? = null
	var cancelListener: (() -> Unit)? = null

	init {
		widget.cancelClickListener = {
			cancelListener?.invoke()
			hide()
		}

		val adapter = PickerAdapter((1000..10000 step 1000).map { it.toString() })

		widget.listFrom?.adapter = adapter
		widget.listTo?.adapter = adapter
	}

	fun show() {
		widget.show()
	}

	private fun hide() {
		widget.hide()
	}
}
