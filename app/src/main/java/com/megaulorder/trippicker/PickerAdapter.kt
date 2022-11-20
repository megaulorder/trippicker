package com.megaulorder.trippicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PickerAdapter(var items: List<String>) :
	RecyclerView.Adapter<PickerViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickerViewHolder {
		return PickerViewHolder(
			LayoutInflater.from(parent.context)
				.inflate(R.layout.picker_item, parent, false) as TextView
		)
	}

	override fun onBindViewHolder(holder: PickerViewHolder, position: Int) {
		holder.bind(items[position])
	}

	override fun getItemCount(): Int = items.size
}

class PickerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

	fun bind(text: String) {
		(itemView as TextView).text = text
	}
}