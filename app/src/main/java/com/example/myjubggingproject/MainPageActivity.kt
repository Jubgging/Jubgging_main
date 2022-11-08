package com.example.myjubggingproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myjubggingproject.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root) //그릴 xml 뷰 파일을 연결 시켜준다.

        // 기록 버튼을 누르면 화면 전환
        binding.btnTimeImg.setOnClickListener {
            startActivity(Intent(this@MainPageActivity, RecordPageActivity::class.java))
        }
    }
}