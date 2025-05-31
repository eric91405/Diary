package com.example.diary

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diary: Diary)  // suspend 필수

    @Query("DELETE FROM diary WHERE id = :diaryId")
    suspend fun delete(diaryId: Int)  // suspend 필수

    @Query("SELECT * FROM diary ORDER BY id DESC")
    fun getAllDiaries(): Flow<List<Diary>>
}
