package com.example.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DiaryViewModel(private val repository: DiaryRepository) : ViewModel() {

    val allDiaries = repository.allDiaries.asLiveData()

    fun insert(diary: Diary) = viewModelScope.launch {
        repository.insert(diary)
    }

    fun delete(diaryId: Int) = viewModelScope.launch {
        repository.delete(diaryId)
    }
}
