package com.example.foody.presentation.untils.extension

import kotlin.math.roundToLong

fun String.copyWith(alpha: Double): String {
    val alphaFixed: Long = (alpha
            * 255).roundToLong()
    var alphaHex: String = alphaFixed.toString(16)

    return this.replace("#", "#$alphaHex")
}
