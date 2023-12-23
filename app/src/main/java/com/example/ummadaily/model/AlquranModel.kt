package com.example.ummadaily.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlquranModel(
    val Surah : String
) : Parcelable