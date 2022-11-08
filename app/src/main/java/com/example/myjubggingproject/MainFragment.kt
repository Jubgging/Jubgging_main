package com.example.myjubggingproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

//Fragment 상속
class MainFrag : Fragment(){
    // MainFrag랑 해당 xml 파일 연결
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.record_fragment, container, false)
        return view
    }
}