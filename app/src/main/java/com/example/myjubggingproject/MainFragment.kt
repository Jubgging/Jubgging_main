package com.example.myjubggingproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myjubggingproject.MainFragment.Companion.AppId
import com.example.myjubggingproject.MainFragment.Companion.BaseUrl
import com.example.myjubggingproject.MainFragment.Companion.lat
import com.example.myjubggingproject.MainFragment.Companion.lon
import com.example.myjubggingproject.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}

/*-------------------------------------날씨 구현-----------------------------------------------------*/
