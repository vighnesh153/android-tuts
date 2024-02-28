package com.example.allaboutviews.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.allaboutviews.data.MyComment
import com.example.allaboutviews.databinding.CommentViewBinding

class MyRecyclerViewAdapter(private val fragment: Fragment) :
    ListAdapter<MyComment, MyRecyclerViewAdapter.ViewHolder>(MyCommentDiffer()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), fragment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: CommentViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(myComment: MyComment, fragment: Fragment) {
            binding.myComment = myComment
            Glide.with(fragment)
                .load(myComment.imageUrl?.toUri())
                .into(binding.imageView)
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