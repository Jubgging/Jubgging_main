package com.example.myjubggingproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myjubggingproject.databinding.ActivityMainBinding

//메인 화면
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //뷰가 생성되었을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //그릴 xml 뷰 파일을 연결 시켜준다.

        // 시작하기 버튼 누르면 화면 전환
        binding.startId.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainPageActivity::class.java))
        }



    }
}