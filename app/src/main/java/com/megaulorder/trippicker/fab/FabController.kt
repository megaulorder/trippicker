package com.megaulorder.trippicker.fab

import com.megaulorder.trippicker.bottomsheet.RangePickerDialogController

class FabController(
	private val widget: FabWidget,
	private val rangePickerDialogController: RangePickerDialogController,
) {

	init {
		widget.onClickListener = { rangePickerDialogController.show() }
	}
}