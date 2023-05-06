package com.example.madproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.madproject.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val user= Firebase.auth.currentUser

        val profileim=findViewById<ImageView>(R.id.homeProf)
        profileim.setOnClickListener {

            if (user==null){
                Toast.makeText(this,"You Are Not Logged In!!!", Toast.LENGTH_SHORT).show()
                val loginint=Intent(this, LogIn::class.java)
                startActivity(loginint)
            }
            val navprof=Intent(this, UserProfile::class.java)
            startActivity(navprof)
        }
    }
}