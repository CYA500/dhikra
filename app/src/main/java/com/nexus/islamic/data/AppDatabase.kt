package com.nexus.islamic.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [IslamicEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun islamicDao(): IslamicDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "nexus_islamic_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
