package com.example.myjubggingproject.repository

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Repository {
    val database = Firebase.database
    val userRef = database.getReference("user")

}

