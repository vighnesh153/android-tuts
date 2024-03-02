package com.example.allaboutviews.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.allaboutviews.database.CommentDatabase
import com.example.allaboutviews.database.PhotosDatabase
import com.example.allaboutviews.repository.CommentsRepository
import com.example.allaboutviews.repository.PhotosRepository
import retrofit2.HttpException

class RefreshDataWork(
    context: Context,
    params: WorkerParameters,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val commentsDatabase = CommentDatabase.getInstance(applicationContext)
        val commentsRepository = CommentsRepository(commentsDatabase)

        val photosDatabase = PhotosDatabase.getInstance(applicationContext)
        val photosRepository = PhotosRepository(photosDatabase)

        try {
            commentsRepository.refreshComments()
            photosRepository.refreshPhotos()
            return Result.success()
        } catch (e: HttpException) {
            return Result.retry()
        }
    }

    companion object {
        const val WORK_NAME: String = "RefreshDataWork"
    }
}