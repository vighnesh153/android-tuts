package com.example.allaboutviews.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.allaboutviews.database.PhotosDatabase
import com.example.allaboutviews.database.entities.asDomainModel
import com.example.allaboutviews.domain.MyPhoto
import com.example.allaboutviews.domain.asDatabaseModel
import com.example.allaboutviews.network.JsonPlaceholderApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PhotosRepository(private val database: PhotosDatabase) {
    val photos: LiveData<List<MyPhoto>> =
        database.photosDao.getPhotos().map { it.asDomainModel() }

    suspend fun refreshPhotos() {
        withContext(Dispatchers.IO) {
            val photos = JsonPlaceholderApi.jsonPlaceholderApiService.getPhotos()
            database.photosDao.insertAll(*photos.asDatabaseModel())
        }
    }
}
