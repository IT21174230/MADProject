package com.example.project.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.project.R
import com.example.project.models.CharityModel
import com.google.firebase.database.FirebaseDatabase

class Update_Profile : AppCompatActivity() {

    private lateinit var tvCharityVoId : EditText
    private lateinit var tvCharityName : EditText
    private lateinit var tvCharityOgName : EditText
    private lateinit var tvCharityEmail : EditText
    private lateinit var tvCharityAddress : EditText
    private lateinit var tvCharityTelNo : EditText
    private lateinit var tvCharityPersonNo : EditText
    private lateinit var tvCharityWeb : EditText
    private lateinit var tvCharityPass : EditText

    private lateinit var updateBtn :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        initView()
        setValuesToViews()

        updateBtn.setOnClickListener{
            updateTaskData(
                intent.getStringExtra("cId").toString(),
                tvCharityVoId.text.toString(),
                tvCharityName.text.toString(),
                tvCharityOgName.text.toString(),
                tvCharityWeb.text.toString(),
                tvCharityEmail.text.toString(),
                tvCharityAddress.text.toString(),
                tvCharityTelNo.text.toString(),
                tvCharityPersonNo.text.toString(),
                tvCharityPass.text.toString()
            )
        }

    }


    private fun initView(){
        tvCharityVoId = findViewById(R.id.etCharityVoid)
        tvCharityName = findViewById(R.id.etCharityName)
        tvCharityOgName = findViewById(R.id.etCharityOgName)
        tvCharityWeb = findViewById(R.id.etCharityWeb)
        tvCharityEmail = findViewById(R.id.etCharityEmail)
        tvCharityAddress = findViewById(R.id.etCharityAddress)
        tvCharityTelNo = findViewById(R.id.etCharityTel)
        tvCharityPersonNo = findViewById(R.id.etCharityPersonNo)
        tvCharityPass = findViewById(R.id.etCharityPass)

        updateBtn = findViewById(R.id.btnUpdateData)



    }

    private fun setValuesToViews(){

        tvCharityVoId.setText(intent.getStringExtra("charityVoId"))
        tvCharityName.setText(intent.getStringExtra("charityName"))
        tvCharityOgName.setText(intent.getStringExtra("charityOgName"))
        tvCharityWeb.setText(intent.getStringExtra("CharityWeb"))
        tvCharityEmail.setText(intent.getStringExtra("CharityEmail"))
        tvCharityAddress.setText(intent.getStringExtra("CharityAddress"))
        tvCharityTelNo.setText(intent.getStringExtra("CharityTelNo"))
        tvCharityPersonNo.setText(intent.getStringExtra("CharityPersonalNo"))
        tvCharityPass.setText(intent.getStringExtra("CharityPass"))
    }

    private fun updateTaskData(
        id:String,
        CharityVoid:String,
        CharityName:String,
        CharityOgName:String,
        CharityWeb:String,
        CharityEmail:String,
        CharityAddress:String,
        CharityTelNo:String,
        CharityPersonNo:String,
        CharityPass:String
     ) {

        val dbRef = FirebaseDatabase.getInstance().getReference("CharityInfo").child(id)
        val charityInfo = CharityModel(id,CharityName,CharityOgName,CharityWeb,CharityEmail,CharityAddress,CharityTelNo,CharityPersonNo,CharityPass)
        val task = dbRef.setValue(charityInfo)

        task.addOnSuccessListener {
            Toast.makeText(this, "Profile data updated", Toast.LENGTH_LONG).show()

            val intent = Intent(this, Charity_Profile::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener { error ->
            Toast.makeText(this, "Update Error ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

}