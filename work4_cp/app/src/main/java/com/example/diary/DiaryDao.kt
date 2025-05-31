package com.example.diary

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(diary: Diary)

    // id로 다이어리 삭제
    @Query("DELETE FROM diary WHERE id = :diaryId")
    fun delete(diaryId: Int)

    // 모든 다이어리를 비동기 스트림으로 가져오기
    @Query("SELECT * FROM diary ORDER BY id DESC")
    fun getAllDiaries(): Flow<List<Diary>>


}
