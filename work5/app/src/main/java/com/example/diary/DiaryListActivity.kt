package com.example.diary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diary.databinding.FragmentDiaryBinding

class DiaryListActivity : AppCompatActivity() {

    private lateinit var binding: FragmentDiaryBinding
    private lateinit var viewModel: DiaryViewModel
    private lateinit var adapter: DiaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DiaryAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // ViewModel 초기화 (ViewModelFactory가 있다면 여기에 적용)
        val repository = DiaryRepository(DiaryDatabase.getDatabase(this).diaryDao())
        viewModel = ViewModelProvider(this, DiaryViewModelFactory(repository))[DiaryViewModel::class.java]

        // LiveData 옵저빙하여 데이터 변경시 RecyclerView 업데이트
        viewModel.allDiaries.observe(this) { diaries ->
            adapter.submitList(diaries)
        }
    }
}
