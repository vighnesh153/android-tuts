package com.example.allaboutviews.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.allaboutviews.database.entities.DatabasePhoto

@Dao
interface PhotosDao {
    @Query("select * from photos")
    fun getPhotos(): LiveData<List<DatabasePhoto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg photos: DatabasePhoto)
}