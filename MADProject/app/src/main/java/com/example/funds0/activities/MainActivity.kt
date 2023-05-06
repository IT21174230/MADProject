package com.example.funds0.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.funds0.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var startbtn=findViewById<Button>(R.id.startbtn)
        startbtn.setOnClickListener {
            val intent=Intent(this, bankinfo::class.java)
            startActivity(intent)
        }
    }
}