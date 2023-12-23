package com.example.ummadaily.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtikelModel(
    val imageArikel : Int,
    val titleArtikel : String,
    val descArtikel: String
) : Parcelable