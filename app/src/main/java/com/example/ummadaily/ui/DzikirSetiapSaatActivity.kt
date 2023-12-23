package com.example.ummadaily.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ummadaily.adapter.DzikirDoaAdapter
import com.example.ummadaily.databinding.ActivityDzikirSetiapSaatBinding
import com.example.ummadaily.model.DoaDzikirDoaModel

class DzikirSetiapSaatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Setiap Saat"

        binding.apply {
            rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this@DzikirSetiapSaatActivity)
            rvDzikirSetiapSaat.adapter = DzikirDoaAdapter(DoaDzikirDoaModel.listDzikir)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}