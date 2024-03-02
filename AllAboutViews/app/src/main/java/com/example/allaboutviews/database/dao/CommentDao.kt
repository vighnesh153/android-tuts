package com.example.allaboutviews.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.allaboutviews.database.entities.DatabaseComment

@Dao
interface CommentDao {
    @Query("select * from comments")
    fun getComments(): LiveData<List<DatabaseComment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg comments: DatabaseComment)
}