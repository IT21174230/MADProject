package com.example.products.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.products.R

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)

        button.setOnClickListener{
            val intent= Intent(this, item_clothes::class.java)
            startActivity(intent)
        }


    }
}