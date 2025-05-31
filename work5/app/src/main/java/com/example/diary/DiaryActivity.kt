package com.example.diary

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.diary.databinding.ActivityDiaryBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DiaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiaryBinding

    private val diaryViewModel: DiaryViewModel by viewModels {
        DiaryViewModelFactory((application as DiaryApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtnIv.setOnClickListener {
            finish()
        }

        binding.analyzeBtn.setOnClickListener {
            val content = binding.diaryInputEt.text.toString()
            if (content.isNotBlank()) {
                val diary = Diary(
                    content = content,
                    title = "제목없음",
                    date = getCurrentDateString()
                )
                diaryViewModel.insert(diary)
                finish()
            }
        }
    }
}

// 날짜 반환 함수 - 꼭 DiaryActivity.kt 내에 포함시키세요
fun getCurrentDateString(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return sdf.format(Date())
}
