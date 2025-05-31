package com.example.diary

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.diary.databinding.ActivityDiaryBinding
import java.text.SimpleDateFormat
import java.util.*

class DiaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiaryBinding

    private val viewModel: DiaryViewModel by viewModels {
        DiaryViewModelFactory((application as DiaryApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로가기 버튼 클릭 시 액티비티 종료
        binding.backBtnIv.setOnClickListener {
            finish()
        }

        // 저장 버튼 클릭 시 일기 저장
        binding.analyzeBtn.setOnClickListener {
            val content = binding.diaryInputEt.text.toString().trim()

            if (content.isEmpty()) {
                Toast.makeText(this, "일기 내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
            val currentDate = sdf.format(Date())

            val diary = Diary(
                title = currentDate,  // 제목이 따로 없으면 날짜로 임시 저장
                content = content,
                date = currentDate
            )

            // 데이터베이스에 저장
            viewModel.insert(diary)

            Toast.makeText(this, "일기가 저장되었습니다.", Toast.LENGTH_SHORT).show()

            // 저장 후 입력창 비우기
            binding.diaryInputEt.text.clear()
        }
    }
}
