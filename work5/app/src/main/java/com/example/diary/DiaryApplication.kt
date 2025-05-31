package com.example.diary

import android.app.Application

class DiaryApplication : Application() {

    // Room 데이터베이스를 지연 초기화(lazy)
    val database by lazy { DiaryDatabase.getDatabase(this) }

    // Repository도 지연 초기화, database.diaryDao()를 넘겨줌
    val repository by lazy { DiaryRepository(database.diaryDao()) }
}
