package com.example.f21comp3025resturantrater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.f21comp3025resturantrater.databinding.ActivityGridRecyclerViewBinding
import com.example.f21comp3025resturantrater.databinding.ActivityRecyclerListBinding

class GridRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGridRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get data from the view model

        val viewModel : RestaurantListViewModel by viewModels()
        viewModel.getRestaurants().observe(this, {restaurants ->
            var gridAdapter = GridAdapter(this, restaurants)
            binding.verticalGridRestaurantRecyclerView.adapter = gridAdapter
        })



    }
}