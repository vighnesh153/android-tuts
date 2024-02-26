package com.example.allaboutviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _comments = MutableLiveData<List<MyComment>?>(
        listOf(
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
    )
    val comments: LiveData<List<MyComment>?>
        get() = _comments
}