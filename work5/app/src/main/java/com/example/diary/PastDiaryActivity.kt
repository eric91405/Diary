package com.example.diary

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary.databinding.ActivityPastDiaryBinding
import kotlinx.coroutines.launch

class PastDiaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPastDiaryBinding
    private val diaryViewModel: DiaryViewModel by viewModels {
        DiaryViewModelFactory((application as DiaryApplication).repository)
    }

    private lateinit var adapter: DiaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPastDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DiaryAdapter()
        binding.diaryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.diaryRecyclerView.adapter = adapter

        // ViewModel에서 저장된 다이어리 리스트 구독
        lifecycleScope.launch {
            diaryViewModel.allDiaries.collect { diaries ->
                Log.d("PastDiaryActivity", "diaries 수 = ${diaries.size}")
                diaries.forEach {
                    Log.d("PastDiaryActivity", "Diary item: $it")
                }
                adapter.submitList(diaries)  // 데이터가 바뀔 때마다 어댑터에 넘겨서 UI 갱신
            }
        }
    }
}
