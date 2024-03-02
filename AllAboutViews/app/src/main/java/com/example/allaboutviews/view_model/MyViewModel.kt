package com.example.allaboutviews.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allaboutviews.database.CommentDatabase
import com.example.allaboutviews.database.PhotosDatabase
import com.example.allaboutviews.domain.MyComment
import com.example.allaboutviews.domain.MyPhoto
import com.example.allaboutviews.repository.CommentsRepository
import com.example.allaboutviews.repository.PhotosRepository
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : ViewModel() {
    private val commentsDatabase = CommentDatabase.getInstance(application)
    private val commentsRepository = CommentsRepository(commentsDatabase)

    private val photosDatabase = PhotosDatabase.getInstance(application)
    private val photosRepository = PhotosRepository(photosDatabase)

    private val comments = commentsRepository.comments
    private val photos = photosRepository.photos

    val commentsWithPhotos = CommentsWithPhotos(
        comments = comments,
        photos = photos,
    )

    init {
        viewModelScope.launch {
            commentsRepository.refreshComments()
            photosRepository.refreshPhotos()
        }
    }
}
