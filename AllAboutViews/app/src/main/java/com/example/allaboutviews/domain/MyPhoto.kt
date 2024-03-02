package com.example.allaboutviews.domain

import com.example.allaboutviews.database.entities.DatabasePhoto

data class MyPhoto(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
)

fun List<MyPhoto>.asDatabaseModel(): Array<DatabasePhoto> {
    return map {
        DatabasePhoto(
            id = it.id,
            albumId = it.albumId,
            title = it.title,
            url = it.url,
            thumbnailUrl = it.thumbnailUrl,
        )
    }.toTypedArray()
}
