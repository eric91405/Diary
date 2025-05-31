package com.example.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DiaryViewModel(private val repository: DiaryRepository): ViewModel() {

    // UI에서 구독할 수 있도록 StateFlow로 변환 (실시간 데이터 감지용)
    val allDiaries: StateFlow<List<Diary>> = repository.allDiaries
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    // 다이어리 추가 함수
    fun insert(diary: Diary) {
        viewModelScope.launch {
            repository.insert(diary)
        }
    }

    //다이어리 삭제 함수
    fun delete(diaryId: Int) {
        viewModelScope.launch {
            repository.delete(diaryId)
        }
    }
}