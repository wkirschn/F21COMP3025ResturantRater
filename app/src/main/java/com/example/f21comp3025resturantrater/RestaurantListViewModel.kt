package com.example.f21comp3025resturantrater

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class RestaurantListViewModel :ViewModel()
{
    // This will hold a mutable list of Restaurant objects

    private val restaurants = MutableLiveData<List<Restaurant>>()

    init {
        loadRestaurants()
    }

    /**
     * This method will load the Restaurant objects from Firebase.FireStore
     * https://www.firebase.google.com/docs/firestore/query-data/listen#kotlin+ktx
     */

    private fun loadRestaurants()
    {
        val db = FirebaseFirestore.getInstance().collection("resturants")
            .orderBy("name", Query.Direction.ASCENDING)


        db.addSnapshotListener { documents, exception ->

            // if there is an exception, let's log it...

            exception?.let {
                Log.i("DB_Response", "listen failed : " + exception)
                return@addSnapshotListener
            }

            Log.i("DB_Response", "# of elements returned: ${documents?.size()}")


            // create an array list of Restaurant objects that will be used to
            // populate the MutableLiveData variable called restaurants

            val restaurantList = ArrayList<Restaurant>()

            // loop over the documents from the DB and create Restaurant objects

            documents?.let{
                for (document in documents)
                {
                    try {
                        val restaurant = document.toObject(Restaurant::class.java)
                        restaurantList.add(restaurant)
                    }
                    catch(e : Exception)
                    {
                        Log.i("DB_Response", "Error in comparing documents in database! " + document.toString())
                    }
                }
            }
            restaurants.value = restaurantList



        }

    }


    fun getRestaurants() : LiveData<List<Restaurant>>
    {
        return restaurants
    }


}