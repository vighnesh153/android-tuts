package com.example.allaboutviews.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CommentDao {
    @Query("select * from comments")
    suspend fun getComments(): LiveData<List<DatabaseComment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg comments: DatabaseComment)
}