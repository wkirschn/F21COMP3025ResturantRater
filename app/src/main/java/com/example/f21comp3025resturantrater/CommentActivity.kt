package com.example.f21comp3025resturantrater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.f21comp3025resturantrater.databinding.ActivityCommentBinding

class CommentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}