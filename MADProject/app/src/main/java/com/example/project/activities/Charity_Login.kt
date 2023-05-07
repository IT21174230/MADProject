package com.example.project.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.project.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //database connection
        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        //signup page linking
        val signUpbutton = findViewById<Button>(R.id.signUpBtn)
        signUpbutton.setOnClickListener {
            val intent = Intent(this, SignupSelection::class.java)
            startActivity(intent)
        }

        //logInButton
        val logBtn = findViewById<Button>(R.id.logInBtn)
        logBtn.setOnClickListener {
            val intent = Intent(this, AllCharities::class.java)
            startActivity(intent)
        }

    }
}