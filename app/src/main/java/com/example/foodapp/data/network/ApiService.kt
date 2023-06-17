package com.example.foodapp.data.network

import com.example.foodapp.data.network.model.DetailFoodInfoDto
import com.example.foodapp.data.network.model.FoodByCategoryResultDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php?c={categoryName}")
    suspend fun getFoodListByCategory(
        @Path("categoryName") name: String
    ): FoodByCategoryResultDto

    @GET("lookup.php?i={foodId}")
    suspend fun getFoodDetailInfo(
        @Path("foodId") id: Int
    ): DetailFoodInfoDto
}