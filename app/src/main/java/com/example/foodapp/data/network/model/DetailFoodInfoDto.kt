package com.example.foodapp.data.network.model

import com.google.gson.annotations.SerializedName

data class DetailFoodInfoDto(
    @SerializedName("meals")
    val foodInfo: List<FoodInfoDto>
)