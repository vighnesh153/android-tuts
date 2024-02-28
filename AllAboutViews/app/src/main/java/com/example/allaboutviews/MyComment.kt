package com.example.allaboutviews

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyComment(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String,
    val imageUrl: String? = null,
) : Parcelable
