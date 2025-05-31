package com.example.diary

import kotlinx.coroutines.flow.Flow

class DiaryRepository(private val diaryDao: DiaryDao) {

    val allDiaries: Flow<List<Diary>> = diaryDao.getAllDiaries()

    suspend fun insert(diary: Diary) {
        diaryDao.insert(diary)
    }

    suspend fun delete(diaryId: Int) {
        diaryDao.delete(diaryId) // 반환값 Int는 무시해도 됨
    }
}
