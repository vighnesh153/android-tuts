package com.example.allaboutviews.domain

import android.os.Parcelable
import com.example.allaboutviews.database.DatabaseComment
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

fun List<MyComment>.asDatabaseModel(): List<DatabaseComment> {
    return map {
        DatabaseComment(
            id = it.id,
            postId = it.postId,
            name = it.name,
            email = it.email,
            body = it.body,
            imageUrl = it.imageUrl,
        )
    }
}
