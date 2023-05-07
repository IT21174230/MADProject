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
import com.example.project.adpters.CharityAdapter
import com.example.project.models.CharityModel
import com.google.firebase.database.FirebaseDatabase

class Charity_Profile : AppCompatActivity() {

    private lateinit var tvCharityVoId : TextView
    private lateinit var tvCharityName : TextView
    private lateinit var tvCharityOgName : TextView
    private lateinit var tvCharityEmail : TextView
    private lateinit var tvCharityAddress : TextView
    private lateinit var tvCharityTelNo : TextView
    private lateinit var tvCharityPersonNo : TextView
    private lateinit var tvCharityWeb : TextView
    private lateinit var tvCharityPass : TextView

    //buttons
    private lateinit var backBtn : Button
    private lateinit var updateBtn : Button
    private lateinit var deleteBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charity_profile)

        initView()
        setValuesToViews()

        //link back
        backBtn = findViewById(R.id.btnBackCharityprofile)
        backBtn.setOnClickListener{
            val intent = Intent(this, AllCharities::class.java)
            startActivity(intent)
        }

        //update data
        updateBtn = findViewById(R.id.btnCharityProfileEdt)
//        updateBtn.setOnClickListener{
//            openUpdateDialog(
//                intent.getStringExtra("cId").toString(),
//                intent.getStringExtra("charityName").toString()
//
//          )
//        }
        updateBtn.setOnClickListener {
            val intent = Intent(this@Charity_Profile, Update_Profile::class.java)
            //put extras
            intent.putExtra("cId", intent.getStringExtra("cId"))
            intent.putExtra("CharityVold", intent.getStringExtra("CharityVold"))
            intent.putExtra("charityName", intent.getStringExtra("charityName"))
            intent.putExtra("charityOgName", intent.getStringExtra("charityOgName"))
            intent.putExtra("CharityEmail", intent.getStringExtra("CharityEmail"))
            intent.putExtra("CharityAddress", intent.getStringExtra("CharityAddress"))
            intent.putExtra("CharityTelNo", intent.getStringExtra("CharityTelNo"))
            intent.putExtra("CharityPersonalNo", intent.getStringExtra("CharityPersonalNo"))
            intent.putExtra("CharityWeb", intent.getStringExtra("CharityWeb"))
            intent.putExtra("CharityPass", intent.getStringExtra("CharityPass"))
            startActivity(intent)
        }

        //delete data
        deleteBtn = findViewById(R.id.btnCharityProfileDelete)
        deleteBtn.setOnClickListener{
            deleteProfile(
                intent.getStringExtra("cId").toString()
            )
        }


    }

    //deleteProfile Function
    private fun deleteProfile(
        id : String

    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("CharityInfo").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this,"Your charity profile deleted Successfully",Toast.LENGTH_LONG).show()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }.addOnFailureListener { error ->
            Toast.makeText(this,"Deleting error ${error.message}",Toast.LENGTH_LONG).show()
        }
    }
    private fun initView(){
        tvCharityVoId = findViewById(R.id.RegistrationID)
        tvCharityName = findViewById(R.id.CharityName)
        tvCharityOgName = findViewById(R.id.OgName)
        tvCharityWeb = findViewById(R.id.charityWebsite)
        tvCharityEmail = findViewById(R.id.CharityEmail)
        tvCharityAddress = findViewById(R.id.CharityAddress)
        tvCharityTelNo = findViewById(R.id.TeleNo)
        tvCharityPersonNo = findViewById(R.id.PersonNum)
        tvCharityPass = findViewById(R.id.charityPassword)

    }

    private fun setValuesToViews(){
        tvCharityVoId.text = intent.getStringExtra("CharityVold")
        tvCharityName.text = intent.getStringExtra("charityName")
        tvCharityOgName.text = intent.getStringExtra("charityOgName")
        tvCharityWeb.text = intent.getStringExtra("CharityWeb")
        tvCharityEmail.text = intent.getStringExtra("CharityEmail")
        tvCharityAddress.text = intent.getStringExtra("CharityAddress")
        tvCharityTelNo.text = intent.getStringExtra("CharityTelNo")
        tvCharityPersonNo.text = intent.getStringExtra("CharityPersonalNo")
        tvCharityPass.text = intent.getStringExtra("CharityPass")
    }

//    private fun openUpdateDialog(
//        cId: String,
//        cName: String
//    ){
//
//        val mDialog = AlertDialog.Builder(this)
//        val inflater = layoutInflater
//        val mDialogView = inflater.inflate(R.layout.activity_update_profile,null)
//
//        mDialog.setView(mDialogView)
//
//        val intent = Intent(this, Update_Profile::class.java)
//
//
//      //  val etCharityVoId = mDialogView.findViewById<EditText>(R.id.etCharityVoid)
//        val etCharityName = mDialogView.findViewById<EditText>(R.id.etCharityName)
//        val etCharityOgName = mDialogView.findViewById<EditText>(R.id.etCharityOgName)
//        val etCharityWeb = mDialogView.findViewById<EditText>(R.id.etCharityWeb)
//        val etCharityEmail = mDialogView.findViewById<EditText>(R.id.etCharityEmail)
//        val etCharityAddress = mDialogView.findViewById<EditText>(R.id.etCharityAddress)
//        val etCharityTelNo = mDialogView.findViewById<EditText>(R.id.etCharityTel)
//        val etCharityPersonNo = mDialogView.findViewById<EditText>(R.id.etCharityPersonNo)
//        val etCharityPass = mDialogView.findViewById<EditText>(R.id.etCharityPass)
//
//        val updateSaveBtn = mDialogView.findViewById<Button>(R.id.btnUpdateData)
//
//        etCharityName.setText(intent.getStringExtra("charityName").toString())
//        etCharityWeb.setText(intent.getStringExtra("CharityWeb").toString())
//        etCharityEmail.setText(intent.getStringExtra("CharityEmail").toString())
//        etCharityAddress.setText(intent.getStringExtra("CharityAddress").toString())
//        etCharityTelNo.setText(intent.getStringExtra("CharityTelNo").toString())
//        etCharityPersonNo.setText(intent.getStringExtra("CharityPersonalNo").toString())
//        etCharityPass.setText(intent.getStringExtra("CharityPass").toString())
//
//        mDialog.setTitle(("Updating $cName Record"))
//
//        val alertDialog = mDialog.create()
//        alertDialog.show()
//
//        updateSaveBtn.setOnClickListener{
//            updateCharityData(
//                cId,
//                etCharityVoId.text.toString(),
//                etCharityName.text.toString(),
//                etCharityOgName.text.toString(),
//                etCharityWeb.text.toString(),
//                etCharityEmail.text.toString(),
//                etCharityAddress.text.toString(),
//                etCharityTelNo.text.toString(),
//                etCharityPersonNo.text.toString(),
//                etCharityPass.text.toString()
//
//            )
//
//        }
//
//        //setting updated data
//        tvCharityVoId.text = etCharityVoId.text.toString()
//        tvCharityName.text = etCharityName.text.toString()
//        tvCharityOgName.text = etCharityOgName.text.toString()
//        tvCharityWeb.text = etCharityWeb.text.toString()
//        tvCharityEmail.text = etCharityEmail.text.toString()
//        tvCharityAddress.text = etCharityAddress.text.toString()
//        tvCharityTelNo.text = etCharityTelNo.text.toString()
//        tvCharityPersonNo.text = etCharityPersonNo.text.toString()
//        tvCharityPass.text = etCharityPass.text.toString()
//
//        alertDialog.dismiss()
//    }

    private fun updateCharityData(
        id: String,
        CharityName: String,
        CharityWeb: String,
        CharityEmail: String,
        CharityAddress: String,
        CharityTelNo: String,
        CharityPersonNo: String,
        CharityPass: String,
        CharityVoid: String,
        CharityOgName: String

    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("CharityInfo").child(id)
        val charityInfo = CharityModel(id,CharityName,CharityWeb,CharityEmail,CharityAddress,CharityTelNo,CharityPersonNo,CharityPass)
        dbRef.setValue(charityInfo).addOnSuccessListener {
            Toast.makeText(applicationContext, "Charity Data Updated!!", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(applicationContext,"Charity Data Update Failed!!", Toast.LENGTH_LONG).show()
        }

    }
}