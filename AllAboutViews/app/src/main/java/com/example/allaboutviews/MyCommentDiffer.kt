package com.example.allaboutviews

import androidx.recyclerview.widget.DiffUtil

class MyCommentDiffer : DiffUtil.ItemCallback<MyComment>() {
    // checks if item has been added, deleted or moved
    override fun areItemsTheSame(oldItem: MyComment, newItem: MyComment): Boolean {
        return oldItem.id == newItem.id
    }

    // checks if item is updated
    override fun areContentsTheSame(oldItem: MyComment, newItem: MyComment): Boolean {
        return oldItem == newItem
    }

}