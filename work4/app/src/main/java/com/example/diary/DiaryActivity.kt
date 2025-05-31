package com.example.diary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.diary.databinding.ActivityDiaryBinding
import com.example.diary.databinding.ActivityMainBinding

class DiaryActivity : AppCompatActivity() { // ← AppCompatActivity 상속 필수!

    private lateinit var binding: ActivityDiaryBinding //바인딩 객체 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDiaryBinding.inflate(layoutInflater) //바인딩 초기화
        setContentView(binding.root) //화면에 보여질 뷰를 설정(binding.root는 최상위 레이아웃 뷰 => activity_main.xml 전체)

        binding.backBtnIv.setOnClickListener {
            finish()    //되돌아가기는 start()가 아니라 finish()
        }
    }


}
