package com.example.ummadaily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.example.ummadaily.adapter.ArtikelAdapter
import com.example.ummadaily.databinding.ActivityMainBinding
import com.example.ummadaily.model.ArtikelModel
import com.example.ummadaily.ui.AlquranActivity
import com.example.ummadaily.ui.DzikirDanDoaHarian
import com.example.ummadaily.ui.DzikirPagiActivity
import com.example.ummadaily.ui.DzikirPetangActivity
import com.example.ummadaily.ui.DzikirSetiapSaatActivity
import com.example.ummadaily.ui.SunnahQauliyahActivity
import com.example.ummadaily.ui.ViewProfile

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var slideIndicator : Array<ImageView?>
    private var listArtikel : ArrayList<ArtikelModel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                slideIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }


            slideIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        installSplashScreen()
        setContentView(binding.root)

        setDataArtikel()
        setUpViewPagerArtikel()
        setView()
    }


    private fun setView() {
        // Setup view artikel
        binding.apply {
            // Set The adapter fot vp2
            vpArtikel.adapter = ArtikelAdapter(listArtikel)
            // Register the OnPageChangeCallBack
            vpArtikel.registerOnPageChangeCallback(slidingCallback)
            llDzikirDoaShalat.setOnClickListener(this@MainActivity)
            llDzikirSetiapSaat.setOnClickListener(this@MainActivity)
            llDzikirDoaHarian.setOnClickListener(this@MainActivity)
            llDzikirPagi.setOnClickListener(this@MainActivity)
            llDzikirPetang.setOnClickListener(this@MainActivity)
            profile.setOnClickListener(this@MainActivity)
            llAlQuran.setOnClickListener(this@MainActivity)
        }
    }


    private fun setDataArtikel() {
        // bagian artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)


        for (data in titleArtikel.indices) {
            val artikel = ArtikelModel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()


    }

    private fun setUpViewPagerArtikel() {
        val llSliderDots = binding.llSliderDots

        slideIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            slideIndicator[i] = ImageView(this)
            slideIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )


            // menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // menerapkan params sebagai aturan bagaimana indicator ditampilkan
            llSliderDots.addView(slideIndicator[i], params)
        }

        slideIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_active
            )
        )

    }
    override fun onDestroy() {
        super.onDestroy()
        binding.vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ll_dzikir_doa_shalat -> {
                val intentDDS = Intent(this@MainActivity, SunnahQauliyahActivity::class.java)
                startActivity(intentDDS)
            }
            R.id.ll_dzikir_setiap_saat -> {
                val intentDSS = Intent(this@MainActivity, DzikirSetiapSaatActivity::class.java)
                startActivity(intentDSS)
            }
            R.id.ll_dzikir_doa_harian -> {
                val intentDDH = Intent(this@MainActivity, DzikirDanDoaHarian::class.java)
                startActivity(intentDDH)
            }
            R.id.ll_dzikir_pagi -> {
                val intentPagi = Intent(this@MainActivity, DzikirPagiActivity::class.java)
                startActivity(intentPagi)
            }
            R.id.ll_dzikir_petang -> {
                val intentPetang = Intent(this@MainActivity, DzikirPetangActivity::class.java)
                startActivity(intentPetang)
            }
            R.id.profile -> {
                val viewprofile = Intent(this@MainActivity, ViewProfile::class.java)
                startActivity(viewprofile)
            }
            R.id.ll_al_quran -> {
                val intentAlquran = Intent(this@MainActivity, AlquranActivity::class.java)
                startActivity(intentAlquran)
            }
        }
    }
}