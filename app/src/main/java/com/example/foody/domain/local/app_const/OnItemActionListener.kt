package com.example.foody.domain.local.app_const

import android.view.View

interface OnItemActionListener {
    fun onTap(view: View, position: Int)
    fun onLongTap(view: View, position: Int)
}