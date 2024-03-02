package com.example.allaboutviews.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.allaboutviews.domain.MyPhoto

@Entity(
    tableName = "photos"
)
data class DatabasePhoto(
    @PrimaryKey
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
)

fun List<DatabasePhoto>.asDomainModel(): List<MyPhoto> {
    return map {
        MyPhoto(
            id = it.id,
            albumId = it.albumId,
            title = it.title,
            url = it.url,
            thumbnailUrl = it.thumbnailUrl,
        )
    }
}
