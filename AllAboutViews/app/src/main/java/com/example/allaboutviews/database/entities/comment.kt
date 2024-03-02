package com.example.allaboutviews.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.allaboutviews.domain.MyComment

@Entity(
    tableName = "comments"
)
data class DatabaseComment(
    @PrimaryKey
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String,
    val imageUrl: String?,
)

fun List<DatabaseComment>.asDomainModel(): List<MyComment> {
    return map {
        MyComment(
            id = it.id,
            postId = it.postId,
            name = it.name,
            email = it.email,
            body = it.body,
            imageUrl = it.imageUrl,
        )
    }
}
