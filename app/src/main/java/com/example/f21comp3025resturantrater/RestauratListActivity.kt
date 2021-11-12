package com.example.f21comp3025resturantrater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.f21comp3025resturantrater.databinding.ActivityRestauratListBinding
import com.google.firebase.firestore.FirebaseFirestore

class RestauratListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRestauratListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestauratListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Connect to the DB

        val db = FirebaseFirestore.getInstance().collection("resturants")

        val query = db.get().addOnSuccessListener {
            documents ->

            //loop for the restaurants
            for (document in documents)
            {
                Log.i("DB Response", "${document.data}")

                //create a restaurant object from the DB

                val restaurant = document.toObject((Restaurant::class.java))


                val textView = TextView(this)
                textView.text = restaurant.name + " " + restaurant.rating.toString()

                textView.textSize = 20f

                binding.layoutGridFetch.addView(textView)
            }
        }




    }
}