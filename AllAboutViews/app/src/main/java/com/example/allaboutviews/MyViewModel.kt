package com.example.allaboutviews

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _comments = MutableLiveData<List<MyComment>?>(defaultComments)
    val comments: LiveData<List<MyComment>?>
        get() = _comments

    private val _photos = MutableLiveData<List<MyPhoto>?>(listOf())
    val photos: LiveData<List<MyPhoto>?>
        get() = _photos

    private val _fetchCommentsError = MutableLiveData<String?>()
    val fetchCommentsError: LiveData<String?>
        get() = _fetchCommentsError

    fun doneProcessingFetchCommentsError() {
        _fetchCommentsError.value = null
    }

    init {
        getAllComments()
        getAllPhotos()
    }

    private fun getAllComments() {
        viewModelScope.launch {
            try {
                val response = JsonPlaceholderApi.jsonPlaceholderApiService.getComments()
                _comments.value = response.map {
                    it.copy(imageUrl = if (photos.value.isNullOrEmpty()) null else photos.value!!.random().url)
                }
            } catch (e: Exception) {
                Log.d("Pikachu", "getAllComments: ${e.message}")
                _fetchCommentsError.value = e.message
            }
        }
    }

    private fun getAllPhotos() {
        viewModelScope.launch {
            try {
                val response = JsonPlaceholderApi.jsonPlaceholderApiService.getPhotos()
                _comments.value = (_comments.value ?: emptyList()).map {
                    it.copy(imageUrl = response.random().url)
                }
                _photos.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

val defaultComments = listOf(
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
