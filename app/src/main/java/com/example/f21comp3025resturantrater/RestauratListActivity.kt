package com.example.f21comp3025resturantrater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.f21comp3025resturantrater.databinding.ActivityRestauratListBinding
import com.google.firebase.firestore.FirebaseFirestore

class RestauratListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRestauratListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestauratListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Connect to the DB

        val db = FirebaseFirestore.getInstance().collection("restaurants")

        val query = db.get().addOnSuccessListener {
            documents ->

            //loop for the restaurants
            for (document in documents)
            {
                Log.i("DB Response", "${document.data}")
            }
        }




    }
}