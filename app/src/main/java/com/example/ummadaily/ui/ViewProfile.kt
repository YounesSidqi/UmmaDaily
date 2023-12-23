package com.example.ummadaily.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ummadaily.R
import com.example.ummadaily.databinding.ActivityViewProfileBinding

class ViewProfile : AppCompatActivity() {

    private lateinit var binding: ActivityViewProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profile"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}