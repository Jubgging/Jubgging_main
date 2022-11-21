package com.example.myjubggingproject.mainViewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//데이터의 변경사항 알려주는 라이브 데이터
class MainViewModel : ViewModel() {

    private val _currentValue = MutableLiveData<Int>()

    //무결성
    val currentValue: LiveData<Int>
        get() = _currentValue

    //초기값
    init {
        _currentValue.value = 0
    }
}

   /* fun updateValue(type: actionType)}
        when(type){
            // 여기서 플로깅 점수 + 1 , - 1 ㄱ구현
} */