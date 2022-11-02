package com.example.myjubggingproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myjubggingproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 시작하기 버튼 누르면 화면 전환
        binding.startId.setOnClickListener {
            startActivity(Intent(this@MainActivity, main_page::class.java))
        }
    }
}