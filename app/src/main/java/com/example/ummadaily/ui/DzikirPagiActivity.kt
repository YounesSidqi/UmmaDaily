package com.example.ummadaily.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ummadaily.adapter.DzikirDoaAdapter
import com.example.ummadaily.databinding.ActivityDzikirPagiBinding
import com.example.ummadaily.model.DoaDzikirDoaModel

class DzikirPagiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Pagi"

        binding.apply {
            rvDzikirPagi.layoutManager = LinearLayoutManager(this@DzikirPagiActivity)
            rvDzikirPagi.adapter = DzikirDoaAdapter(DoaDzikirDoaModel.listDzikirPagi)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}