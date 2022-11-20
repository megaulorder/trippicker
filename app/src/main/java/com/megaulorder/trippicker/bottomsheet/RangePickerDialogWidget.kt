package com.megaulorder.trippicker.bottomsheet

import android.content.Context
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.megaulorder.trippicker.R

class RangePickerDialogWidget(
	private val dialog: BottomSheetDialog,
	cancelIcon: ImageButton?,
) {

	var applyClickListener: ((selectedMinValue: String?, selectedMaxValue: String?) -> Unit)? = null
	var cancelClickListener: (() -> Unit)? = null

	var listFrom: RecyclerView? = null
		private set
	var listTo: RecyclerView? = null
		private set

	init {
		listFrom = dialog.findViewById(R.id.picker_from)
		listTo = dialog.findViewById(R.id.picker_to)
		listFrom?.layoutManager = LinearLayoutManager(dialog.context, LinearLayoutManager.VERTICAL, false)
		listTo?.layoutManager = LinearLayoutManager(dialog.context, LinearLayoutManager.VERTICAL, false)

		cancelIcon?.setOnClickListener { cancelClickListener?.invoke() }
	}

	fun show() {
		dialog.show()
	}

	fun hide() {
		dialog.hide()
	}
}

class RangePickerDialogWidgetFactory(private val context: Context) {

	fun create(): RangePickerDialogWidget {
		val dialog = BottomSheetDialog(context)
		dialog.setContentView(R.layout.bottom_sheet)

		return RangePickerDialogWidget(dialog, dialog.findViewById(R.id.cancel_button))
	}
}