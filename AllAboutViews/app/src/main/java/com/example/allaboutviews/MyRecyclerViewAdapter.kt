package com.example.allaboutviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.allaboutviews.databinding.CommentViewBinding

class MyRecyclerViewAdapter :
    ListAdapter<MyComment, MyRecyclerViewAdapter.ViewHolder>(MyCommentDiffer()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: CommentViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(myComment: MyComment) {
            binding.myComment = myComment
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CommentViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}