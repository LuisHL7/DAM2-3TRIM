package com.example.huapaya_luis_examenfinalzip

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album (
    val title: String,
    val author: String,
    @DrawableRes
    val imageId: Int,
    val description: String,
): Parcelable