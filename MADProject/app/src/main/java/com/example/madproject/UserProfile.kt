package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val edit = findViewById<Button>(R.id.edtBtn)
        edit.setOnClickListener {
            val editInt=Intent(this, EditProfile::class.java)
            startActivity(editInt)
        }
    }


}