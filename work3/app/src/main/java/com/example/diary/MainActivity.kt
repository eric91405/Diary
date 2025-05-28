package com.example.diary

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //바인딩 객체 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //바인딩 초기화
        setContentView(binding.root) //화면에 보여질 뷰를 설정(binding.root는 최상위 레이아웃 뷰 => activity_main.xml 전체)

        binding.writeDiaryBtn.setOnClickListener {
            //Intent를 생성해 DiaryActivity로 이동, this: 현재 액티비티(MainActivity)
            //DiaryActivity::class.java : 이동할 대상 액티비티의 클래스
            val intent = Intent(this, DiaryActivity::class.java)
            //startActivity()로 화면 전환 실행
            startActivity(intent)
        }


    }
}