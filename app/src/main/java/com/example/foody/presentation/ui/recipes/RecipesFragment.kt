package com.example.foody.presentation.ui.recipes

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.R
import com.example.foody.domain.model.RecipesModel

class RecipesFragment : Fragment() {
    val listData: List<RecipesModel> = listOf(
        RecipesModel(
            true,
            30,
            0,
            "Some companies said the interns had just graduated from high school or even secondary schools when applying for the internship program and could only do certain tasks that they were trained for in Japan. Therefore, when returning to Vietnam to work, they have a lot to learn to match their colleagues with greater experience.",
            50,
            "https://9mobi.vn/cf/images/2015/03/nkk/hinh-dep-1.jpg",
            "Some companies said the interns had just graduated from high school or even secondary schools when applying for the internship program and could only do certain tasks that they were trained for in Japan. Therefore, when returning to Vietnam to work, they have a lot to learn to match their colleagues with greater experience."
        ),
        RecipesModel(
            true,
            30,
            0,
            "Cơm gà",
            50,
            "https://9mobi.vn/cf/images/2015/03/nkk/hinh-dep-1.jpg",
            "ncaos aiosna cabcacascn j"
        ),
        RecipesModel(
            true,
            30,
            0,
            "Cơm gà",
            50,
            "https://9mobi.vn/cf/images/2015/03/nkk/hinh-dep-1.jpg",
            "ncaos aiosna cabcacascn j"
        ),
        RecipesModel(
            true,
            30,
            0,
            "Cơm gà",
            50,
            "https://9mobi.vn/cf/images/2015/03/nkk/hinh-dep-1.jpg",
            "ncaos aiosna cabcacascn j"
        ),
        RecipesModel(
            true,
            30,
            0,
            "Cơm gà",
            50,
            "https://9mobi.vn/cf/images/2015/03/nkk/hinh-dep-1.jpg",
            "ncaos aiosna cabcacascn j"
        ),
        RecipesModel(
            true,
            30,
            0,
            "Cơm gà",
            50,
            "https://9mobi.vn/cf/images/2015/03/nkk/hinh-dep-1.jpg",
            "ncaos aiosna cabcacascn j"
        ),
        RecipesModel(
            true,
            30,
            0,
            "Cơm gà",
            50,
            "https://9mobi.vn/cf/images/2015/03/nkk/hinh-dep-1.jpg",
            "ncaos aiosna cabcacascn j"
        ),
    )

    lateinit var recyclerView: RecyclerView

    private fun createUi(view: View) {
        recyclerView = view.findViewById(R.id.rv_recipes)
    }

    private fun createRecyclerView(context: Context) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = RecipesAdapter(listData)
        recyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_recipes, container, false)
        createUi(view)
        activity?.let { createRecyclerView(it) }
        return view
    }
}