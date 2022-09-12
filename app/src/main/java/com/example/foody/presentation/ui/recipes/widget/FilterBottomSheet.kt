package com.example.foody.presentation.ui.recipes.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.R
import com.example.foody.presentation.ui.recipes.adapter.FilterAdapter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheet<T> (adapter: T) : BottomSheetDialogFragment() {
    var dataAdapter : T = adapter

    private lateinit var rvFilter: RecyclerView

    private fun createUi(view: View) {
        rvFilter = view.findViewById(R.id.rv_option)

    }

    private fun createRv() {
        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        rvFilter.layoutManager = layoutManager
        rvFilter.adapter = dataAdapter as RecyclerView.Adapter<*>
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var bottomSheetDialog : BottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        val view : View = LayoutInflater.from(context).inflate(R.layout.fragment_filter_bottom_sheet, null)
        bottomSheetDialog.setContentView(view)

        createUi(view)
        createRv()

        return bottomSheetDialog

    }
}