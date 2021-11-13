package com.example.f21comp3025resturantrater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.f21comp3025resturantrater.databinding.ActivityGridRecyclerViewBinding
import com.example.f21comp3025resturantrater.databinding.ActivityRecyclerListBinding

class GridRecyclerViewActivity : AppCompatActivity(), GridAdapter.RestaurantItemListener {

    private lateinit var binding : ActivityGridRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // get data from the view model

        val viewModel : RestaurantListViewModel by viewModels()
        viewModel.getRestaurants().observe(this, {restaurants ->
            var gridAdapter = GridAdapter(this, restaurants, this)
            binding.verticalGridRestaurantRecyclerView.adapter = gridAdapter
        })



    }

    override fun restaurantSelected(restaurant: Restaurant) {
        val intent = Intent(this, CommentActivity::class.java)
        intent.putExtra("restaurantID", restaurant.id)
        intent.putExtra("restaurantName", restaurant.name)
        startActivity(intent)
    }

    /*
    When a restaurant is selected, pass the Restaurant information to the comment activity
     */


}