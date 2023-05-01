package com.example.madproject

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val profileim=findViewById<ImageView>(R.id.homeProf)
        profileim.setOnClickListener {
            val navprof=Intent(this, UserProfile::class.java)
            startActivity(navprof)
        }
    }
}