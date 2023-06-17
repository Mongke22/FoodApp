package com.example.foodapp.data.network.model

import com.google.gson.annotations.SerializedName

data class FoodInfoDto(
    @SerializedName("strMeal")
    val foodName: String,
    @SerializedName("strInstructions")
    val foodInstructions: String,
    @SerializedName("idMeal")
    val foodId: Int,
)
