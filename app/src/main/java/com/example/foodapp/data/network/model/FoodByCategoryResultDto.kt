package com.example.foodapp.data.network.model

import com.google.gson.annotations.SerializedName

data class FoodByCategoryResultDto(
    @SerializedName("meals")
    val meals: List<MealDto>
)
