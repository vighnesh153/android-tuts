package com.example.android.trackmysleepqualityrecyclerview.recycler_view_stuff

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepqualityrecyclerview.R

class MyAdapter2 : ListAdapter<MyCard, MyAdapter2.ViewHolder>(MyDiffCallback2()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val myText: TextView = itemView.findViewById(R.id.myTextView)

        fun bind(item: MyCard) {
            val textView = myText
            if (item.id.contains("0")) {
                textView.setTextColor(Color.YELLOW)
            } else {
                textView.setTextColor(Color.WHITE)
            }
            textView.text = item.title
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.list_item, parent, false)
                return ViewHolder(view)
            }
        }
    }
}

class MyDiffCallback2 : DiffUtil.ItemCallback<MyCard>() {
    // checks if item has been added, deleted or moved
    override fun areItemsTheSame(oldItem: MyCard, newItem: MyCard): Boolean {
        return oldItem.id == newItem.id
    }

    // checks if item is updated
    override fun areContentsTheSame(oldItem: MyCard, newItem: MyCard): Boolean {
//        return oldItem.id == newItem.id && oldItem.title == newItem.title
        return oldItem == newItem
    }

}
