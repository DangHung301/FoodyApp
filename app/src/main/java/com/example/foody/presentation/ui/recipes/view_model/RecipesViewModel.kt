package com.example.foody.presentation.ui.recipes.view_model

import com.example.foody.domain.model.FilterModel
import com.example.foody.domain.model.RecipesModel

class RecipesViewModel {
    val fakeData: List<RecipesModel> = listOf(
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

    val dataFillter: List<FilterModel> = listOf(
        FilterModel("All", true),
        FilterModel("Newest", false),
        FilterModel("Top Rated", false),
        FilterModel("Most Popular", false),
        FilterModel("Trendy", false),
        FilterModel("Most Liked", false),
    )

    fun selectFilter(option : FilterModel) {
        for(e in dataFillter) {
            e.state = e == option
        }
    }
}