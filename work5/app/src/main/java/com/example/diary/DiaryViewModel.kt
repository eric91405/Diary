package com.example.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DiaryViewModel(private val repository: DiaryRepository) : ViewModel() {

    val allDiaries: StateFlow<List<Diary>> = repository.allDiaries
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun insert(diary: Diary) {
        viewModelScope.launch {
            repository.insert(diary)
        }
    }

    fun delete(diaryId: Int) {
        viewModelScope.launch {
            repository.delete(diaryId)
        }
    }
}
