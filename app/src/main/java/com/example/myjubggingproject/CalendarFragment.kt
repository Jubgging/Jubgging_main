package com.example.myjubggingproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import com.example.myjubggingproject.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Calendar 일정 추가 클릭 이벤트
        binding.calendar.setOnDateChangeListener(CalendarView.OnDateChangeListener { calendarView, year, month, day ->
            binding.btnDate.setText(
                year.toString() + "년 " + (month + 1) + "월 " + day + "일 플로깅 일정 추가하기"
            )
        })
    }

    lateinit var binding : FragmentCalendarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root

    }


}