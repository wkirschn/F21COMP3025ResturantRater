package com.example.f21comp3025resturantrater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f21comp3025resturantrater.databinding.ActivityMainBinding

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

                Toast.makeText(this, "Restaurant name and rating added!", Toast.LENGTH_LONG)
                    .show()


            } else {
                Toast.makeText(this, "Restaurant name and rating required!", Toast.LENGTH_LONG)
                    .show()
            }


        }
    }
}
