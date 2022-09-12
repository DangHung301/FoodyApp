package com.example.foody.presentation.ui.recipes

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.R
import com.example.foody.domain.local.app_const.OnItemActionListener
import com.example.foody.domain.model.FilterModel
import com.example.foody.presentation.ui.recipes.adapter.FilterAdapter
import com.example.foody.presentation.ui.recipes.adapter.RecipesAdapter
import com.example.foody.presentation.ui.recipes.view_model.RecipesViewModel
import com.example.foody.presentation.ui.recipes.widget.FilterBottomSheet

class RecipesFragment() : Fragment() {
    private val recipesViewModel: RecipesViewModel = RecipesViewModel()
    private val adapterFilter = FilterAdapter(recipesViewModel.dataFillter.toMutableList())
    private var filterBottomSheet: FilterBottomSheet<FilterAdapter> =
        FilterBottomSheet(adapterFilter)


    private lateinit var rvRecipes: RecyclerView
    private lateinit var btnFilter: ImageButton

    private fun createUi(view: View) {
        rvRecipes = view.findViewById(R.id.rv_recipes)
        btnFilter = view.findViewById(R.id.btn_menu)

    }

    private fun createRecyclerView(context: Context) {
        //rv of recipes
        rvRecipes.layoutManager = LinearLayoutManager(context)
        rvRecipes.adapter = RecipesAdapter(recipesViewModel.fakeData)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_recipes, container, false)
        createUi(view)
        activity?.let {
            showBottomSheet(it)
        }
        activity?.let { createRecyclerView(it) }

        return view
    }

    private fun setOnclickItemFilter() {
        adapterFilter.setActionListener(object : OnItemActionListener {
            override fun onTap(view: View, position: Int) {
                selectItemData(recipesViewModel.dataFillter[position])
            }

            override fun onLongTap(view: View, position: Int) {
                TODO("Not yet implemented")
            }

        })
    }

    fun selectItemData(option: FilterModel) {
        recipesViewModel.selectFilter(option)
        adapterFilter.updateData(recipesViewModel.dataFillter as MutableList<FilterModel>)
    }

    private fun showBottomSheet(context: Context) {
        setOnclickItemFilter()
        btnFilter.setOnClickListener {
            filterBottomSheet.show(parentFragmentManager, filterBottomSheet.tag)
        }
    }
}