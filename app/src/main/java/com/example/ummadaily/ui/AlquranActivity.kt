package com.example.ummadaily.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ummadaily.R
import com.example.ummadaily.adapter.AlquranAdapter
import com.example.ummadaily.adapter.DzikirDoaAdapter
import com.example.ummadaily.databinding.ActivityAlquranBinding
import com.example.ummadaily.model.AlquranModel

class AlquranActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlquranBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlquranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Surah Al-Quran"

        binding.apply {
            rvAlquran.layoutManager = LinearLayoutManager(this@AlquranActivity)
            rvAlquran.adapter = AlquranAdapter(GetAlquran())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun GetAlquran(): ArrayList<AlquranModel> {
        val surah = resources.getStringArray(R.array.arr_surah_names)

        val kumpul = arrayListOf<AlquranModel>()

        for (i in surah.indices){
            val gabung = AlquranModel(
                surah[i]
            )
            kumpul.addAll(listOf(gabung))
        }
        return kumpul
    }
}