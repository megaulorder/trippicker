package com.megaulorder.trippicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.megaulorder.trippicker.bottomsheet.RangePickerDialogController
import com.megaulorder.trippicker.bottomsheet.RangePickerDialogWidgetFactory
import com.megaulorder.trippicker.fab.FabController
import com.megaulorder.trippicker.fab.FabWidget

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		setSupportActionBar(findViewById(R.id.toolbar))

		val list = findViewById<RecyclerView>(R.id.list)

		val pickerController =
			RangePickerDialogController(RangePickerDialogWidgetFactory(this).create())

		val fabWidget = FabWidget(findViewById(R.id.fab_view), list)
		val fabController = FabController(fabWidget, pickerController)

		list.adapter = ListAdapter((1..50).map { it.toString() })
		list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
	}
}
