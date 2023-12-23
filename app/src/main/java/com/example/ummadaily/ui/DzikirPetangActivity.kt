package com.example.ummadaily.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ummadaily.adapter.DzikirDoaAdapter
import com.example.ummadaily.databinding.ActivityDzikirPetangBinding
import com.example.ummadaily.model.DoaDzikirDoaModel

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Petang"

        binding.apply {
            rvDzikirPetang.layoutManager = LinearLayoutManager(this@DzikirPetangActivity)
            rvDzikirPetang.adapter = DzikirDoaAdapter(DoaDzikirDoaModel.listDzikirPetang)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}