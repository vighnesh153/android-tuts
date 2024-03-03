package com.example.allaboutviews.view_model

import android.app.Application
import android.app.NotificationManager
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allaboutviews.database.CommentDatabase
import com.example.allaboutviews.database.PhotosDatabase
import com.example.allaboutviews.domain.MyComment
import com.example.allaboutviews.domain.MyPhoto
import com.example.allaboutviews.notification.showNotification
import com.example.allaboutviews.repository.CommentsRepository
import com.example.allaboutviews.repository.PhotosRepository
import kotlinx.coroutines.launch

class MyViewModel(private val application: Application) : ViewModel() {
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

    fun onFabClicked() {
        Toast.makeText(application, "Floating action button clicked!", Toast.LENGTH_SHORT).show()
    }

    fun showNotification() {
        val context = application.applicationContext
        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        ) as NotificationManager

        notificationManager.showNotification(
            context = context,
            intent = null,
            messageTitle = "Pikachu Notifications",
            messageBody = "Pikachu received the notification",
        )
    }
}
