package com.nexus.islamic.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface IslamicDao {
    @Query("SELECT * FROM islamic_items WHERE type = :contentType")
    fun getItemsByType(contentType: String): Flow<List<IslamicEntity>>

    @Query("SELECT * FROM islamic_items WHERE category = :cat")
    fun getItemsByCategory(cat: String): Flow<List<IslamicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: IslamicEntity)

    @Delete
    suspend fun deleteItem(item: IslamicEntity)
}
