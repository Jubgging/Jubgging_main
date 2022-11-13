package com.example.myjubggingproject

import android.os.Build
import android.os.Bundle
import android.widget.CalendarView.OnDateChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.myjubggingproject.databinding.ActivityRecordPageBinding
import kotlinx.android.synthetic.main.activity_record_page.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

class RecordPageActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecordPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Calendar 일정 추가 클릭 이벤트
        binding.calendar.setOnDateChangeListener(OnDateChangeListener { calendarView, year, month, day ->
            binding.btnDate.setText(
                year.toString() + "년 " + (month + 1) + "월 " + day + "일 플로깅 일정 추가하기"
            )
        }) */

        // 오늘은 00년 00월 00일 입니다

        val timeDate: String
        // 버전 빌드
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val date = LocalDate.now()
            val dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd") // EEE, MMM d, yy
            timeDate = date.toString()
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        txt_today.text= timeDate

    }
}