package com.example.f21comp3025resturantrater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.f21comp3025resturantrater.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addResturantButton.setOnClickListener {
            if (binding.inputResturantName.text.toString()
                    .isNotEmpty() && binding.ratingSpinner.selectedItemPosition > 0
            ) {
                // Store Firebase Connection



                val restaurant = Restaurant()
                restaurant.name = binding.inputResturantName.text.toString()
                restaurant.rating = binding.ratingSpinner.selectedItem.toString().toInt()

                // Store the restaurant in Firebase - Firestore

                // 1. get an ID from Firestore
                    // Acts as creating a table
                val db = FirebaseFirestore.getInstance().collection("resturants")
                restaurant.id = db.document().id

                // 2. store the restaurant as a document

                db.document(restaurant.id!!).set(restaurant).addOnSuccessListener {
                    Toast.makeText(this, "Restaurant name and rating added!", Toast.LENGTH_LONG)
                        .show()
                    binding.inputResturantName.setText("")
                    binding.ratingSpinner.setSelection(0)
                }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failure to add. DB Error!", Toast.LENGTH_LONG)
                            .show()
                        Log.i("DB Message", it.localizedMessage)
                    }


            } else {
                Toast.makeText(this, "Restaurant name and rating required!", Toast.LENGTH_LONG)
                    .show()
            }


        }
    }
}
