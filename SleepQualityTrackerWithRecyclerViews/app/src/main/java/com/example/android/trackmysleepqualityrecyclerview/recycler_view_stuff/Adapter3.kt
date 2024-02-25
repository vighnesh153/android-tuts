package com.example.android.trackmysleepqualityrecyclerview.recycler_view_stuff

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepqualityrecyclerview.databinding.ListItemBinding

class MyItemListener(val clickListener: (card: MyCard) -> Unit) {
    fun onClick(card: MyCard) = clickListener(card)
}

class MyAdapter3(val clickListener: MyItemListener) : ListAdapter<MyCard, MyAdapter3.ViewHolder>(MyDiffCallback3()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MyCard, clickListener: MyItemListener) {
            binding.myItem = item
            val textColor = if (item.id.contains("0")) Color.YELLOW else Color.WHITE
            binding.myTextView.setTextColor(textColor)
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class MyDiffCallback3 : DiffUtil.ItemCallback<MyCard>() {
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
