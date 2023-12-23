package com.example.ummadaily.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ummadaily.R
import com.example.ummadaily.adapter.DzikirDoaAdapter
import com.example.ummadaily.databinding.ActivityDzikirDanDoaHarianBinding
import com.example.ummadaily.model.DzikirDoaModel

class DzikirDanDoaHarian : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirDanDoaHarianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirDanDoaHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir dan Doa Harian"

        binding.apply {
            rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this@DzikirDanDoaHarian)
            rvDzikirDoaHarian.adapter = DzikirDoaAdapter(GetDzikirDoa())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun GetDzikirDoa(): ArrayList<DzikirDoaModel> {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val kumpul = arrayListOf<DzikirDoaModel>()

        for (i in desc.indices){
            val gabung = DzikirDoaModel(
                desc[i],
                lafaz[i],
                terjemah[i]
            )
            kumpul.addAll(listOf(gabung))

        }
        return kumpul
    }
}