package com.example.allaboutviews.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        DatabaseComment::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CommentDatabase : RoomDatabase() {

    abstract val commentDao: CommentDao

    companion object {

        @Volatile
        private var INSTANCE: CommentDatabase? = null

        fun getInstance(context: Context): CommentDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            CommentDatabase::class.java,
                            "comments_database",
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}