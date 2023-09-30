package com.punchy.imccalculator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonAttributes(
    val weight: Float,
    val height: Float
) : Parcelable
