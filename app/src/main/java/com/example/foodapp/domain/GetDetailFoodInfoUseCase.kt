package com.example.foodapp.domain

class GetDetailFoodInfoUseCase(private val repository: FoodRepository) {
    suspend operator fun invoke(foodId: Int) = repository.getDetailInfo(foodId)
}