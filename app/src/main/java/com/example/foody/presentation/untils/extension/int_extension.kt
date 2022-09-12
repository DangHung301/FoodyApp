package com.example.foody.presentation.untils.extension

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat

fun Int.copyWith(context: Context, withOpacity: Double = 1.0) : Int {
    val hexColor :String = "#${Integer.toHexString(ContextCompat.getColor(context, this)).substring(2)}".copyWith(withOpacity)
    return Color.parseColor(hexColor)
}