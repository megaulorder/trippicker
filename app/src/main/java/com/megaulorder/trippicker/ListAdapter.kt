package com.megaulorder.trippicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(var items: List<String>) :
	RecyclerView.Adapter<ListViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		return ListViewHolder(
			LayoutInflater.from(parent.context)
				.inflate(R.layout.list_item, parent, false) as TextView
		)
	}

	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		holder.bind(items[position])
	}

	override fun getItemCount(): Int = items.size
}

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

	fun bind(text: String) {
		(itemView as TextView).text = text
	}
}
