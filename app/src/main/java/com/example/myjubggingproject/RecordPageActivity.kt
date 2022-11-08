package com.example.myjubggingproject

import android.os.Bundle
import android.widget.CalendarView.OnDateChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.myjubggingproject.databinding.ActivityRecordPageBinding


class RecordPageActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecordPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Calendar 일정 추가 클릭 이벤트
        binding.calendar.setOnDateChangeListener(OnDateChangeListener { calendarView, year, month, day ->
            binding.btnDate.setText(
                year.toString() + "년 " + (month + 1) + "월 " + day + "일 플로깅 일정 추가하기"
            )
        })
    }
}