package com.example.islme.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chapter(
    val index : Int,
    val titleEn : String,
    val titleAr : String,
    val VersesNumber : String
) : Parcelable