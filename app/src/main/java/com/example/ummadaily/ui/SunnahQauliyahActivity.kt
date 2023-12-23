package com.example.ummadaily.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ummadaily.adapter.DzikirDoaAdapter
import com.example.ummadaily.databinding.ActivitySunnahQauliyahBinding
import com.example.ummadaily.model.DoaDzikirDoaModel

class SunnahQauliyahActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySunnahQauliyahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunnahQauliyahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Sunnah - Sunnah Qauliyah"

        binding.apply {
            rvQauliyahShalat.layoutManager = LinearLayoutManager(this@SunnahQauliyahActivity)
            rvQauliyahShalat.adapter = DzikirDoaAdapter(DoaDzikirDoaModel.listQauliyah)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}