package com.example.diary

import android.app.Application

class DiaryApplication : Application() {
    val database by lazy { DiaryDatabase.getDatabase(this) }
    val repository by lazy { DiaryRepository(database.diaryDao()) }
}
