package com.example.diary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DiaryActivity : AppCompatActivity() { // ← AppCompatActivity 상속 필수!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary) // XML 레이아웃 이름
    }
}
