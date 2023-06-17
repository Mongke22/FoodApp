package com.example.foodapp.data.network.model

import com.google.gson.annotations.SerializedName

data class MealDto(
    @SerializedName("strMeal")
    val foodName: String,
    @SerializedName("strMealThumb")
    val foodPicture: String,
    @SerializedName("idMeal")
    val foodId: Int,
)
