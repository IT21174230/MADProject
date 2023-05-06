package com.example.funds0.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.funds0.R

class donorHomepage : AppCompatActivity() {
    private lateinit var btnfund:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor_homepage)

        btnfund=findViewById(R.id.btnfund)

        btnfund.setOnClickListener{
            val intent= Intent(this, DisplayfundsDonor::class.java)
            startActivity(intent)

        }

    }
}