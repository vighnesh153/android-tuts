package com.example.allaboutviews.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.allaboutviews.domain.MyComment
import com.example.allaboutviews.domain.MyPhoto

class CommentsWithPhotos(
    comments: LiveData<List<MyComment>>,
    photos: LiveData<List<MyPhoto>>,
) : MediatorLiveData<List<MyComment>>() {
    init {
        addSource(comments) { comments ->
            value = comments.ifEmpty { defaultComments }.map {
                it.copy(
                    imageUrl = photos.value?.ifEmpty { defaultPhotos }?.random()?.url
                )
            }
        }
        addSource(photos) { photos ->
            value = comments.value?.ifEmpty { defaultComments }?.map {
                it.copy(
                    imageUrl = photos.ifEmpty { defaultPhotos }.random().url
                )
            } ?: emptyList()
        }
    }
}

private val defaultComments = listOf(
    MyComment(
        id = 1,
        postId = 1,
        name = "Pikachu",
        email = "pikachu@pokemon.dev",
        body = "Pi Pikachu, pika pi",
    ),
    MyComment(
        id = 2,
        postId = 1,
        name = "Greninja",
        email = "greninja@pokemon.dev",
        body = "ninja, gre ninja",
    ),
    MyComment(
        id = 3,
        postId = 2,
        name = "Treeko",
        email = "treeko@pokemon.dev",
        body = "Treeko",
    ),
)

private val defaultPhotos = listOf(
    MyPhoto(
        id = 1,
        albumId = 1,
        title = "123",
        url = "https://via.placeholder.com/600/92c952",
        thumbnailUrl = "https://via.placeholder.com/150/92c952"
    ),
    MyPhoto(
        albumId = 1,
        id = 2,
        title = "reprehenderit est deserunt velit ipsam",
        url = "https://via.placeholder.com/600/771796",
        thumbnailUrl = "https://via.placeholder.com/150/771796"
    ),
    MyPhoto(
        albumId = 1,
        id = 3,
        title = "officia porro iure quia iusto qui ipsa ut modi",
        url = "https://via.placeholder.com/600/24f355",
        thumbnailUrl = "https://via.placeholder.com/150/24f355"
    ),
)
