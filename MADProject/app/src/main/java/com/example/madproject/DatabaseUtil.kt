package com.example.madproject

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DatabaseUtil {
    companion object{
        private var firebaseDatabase: FirebaseDatabase? = null

        fun getDatabase(path:String) : DatabaseReference{
            if (firebaseDatabase==null){
                firebaseDatabase = FirebaseDatabase.getInstance()
            }

            return firebaseDatabase!!.getReference(path)
        }
    }
}