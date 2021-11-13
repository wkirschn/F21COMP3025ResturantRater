package com.example.f21comp3025resturantrater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f21comp3025resturantrater.databinding.ActivityCommentBinding
import com.google.firebase.firestore.FirebaseFirestore

class CommentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.restaurantNameTextView.text = intent.getStringExtra("restaurantName")


        binding.saveCommentButton.setOnClickListener {

            val userName = binding.usernameEditText.text.toString()
            val commentBody = binding.bodyEditText.text.toString()


            // create the ability to save a comment
            if (userName.isNotEmpty() && commentBody.isNotEmpty())
            {
                val db = FirebaseFirestore.getInstance().collection("comments")
                val id = db.document().id

                val restaurantID = intent.getStringExtra("restaurantID")
                restaurantID?.let {
                    val newComment = Comment(id, userName, commentBody, restaurantID )
                }
            }
            else
            {
                Toast.makeText(this,"Both user ame and comment are required", Toast.LENGTH_LONG).show()
            }
        }



    }
}