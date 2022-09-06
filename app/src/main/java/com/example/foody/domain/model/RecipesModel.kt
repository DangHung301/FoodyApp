package com.example.foody.domain.model

data class RecipesModel(
    var vegan: Boolean,
    var aggregateLikes: Int,
    var id: Int,
    var title: String,
    var readyInMinutes: Int,
    var image: String?,
    var summary: String,
)