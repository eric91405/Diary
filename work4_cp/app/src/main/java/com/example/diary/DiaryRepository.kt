package com.example.diary

import kotlinx.coroutines.flow.Flow

class DiaryRepository(private val diaryDao: DiaryDao) {

    val allDiaries: Flow<List<Diary>> = diaryDao.getAllDiaries()

    fun insert(diary: Diary) {
        diaryDao.insert(diary)
    }

    fun delete(diaryId: Int) {
        diaryDao.delete(diaryId)
    }
}
