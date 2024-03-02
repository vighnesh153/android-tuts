package com.example.allaboutviews.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.allaboutviews.database.CommentDatabase
import com.example.allaboutviews.database.entities.asDomainModel
import com.example.allaboutviews.domain.MyComment
import com.example.allaboutviews.domain.asDatabaseModel
import com.example.allaboutviews.network.JsonPlaceholderApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommentsRepository(private val database: CommentDatabase) {
    val comments: LiveData<List<MyComment>> =
        database.commentDao.getComments().map { it.asDomainModel() }

    suspend fun refreshComments() {
        withContext(Dispatchers.IO) {
            val comments = JsonPlaceholderApi.jsonPlaceholderApiService.getComments()
            database.commentDao.insertAll(*comments.asDatabaseModel())
        }
    }
}
