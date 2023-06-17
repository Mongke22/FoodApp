package com.example.foodapp.data.network

import com.example.foodapp.data.network.model.DetailFoodInfoDto
import com.example.foodapp.data.network.model.FoodByCategoryResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php")
    suspend fun getFoodListByCategory(
        @Query("c") name: String
    ): FoodByCategoryResultDto

    @GET("lookup.php?i={foodId}")
    suspend fun getFoodDetailInfo(
        @Path("foodId") id: Int
    ): DetailFoodInfoDto
}