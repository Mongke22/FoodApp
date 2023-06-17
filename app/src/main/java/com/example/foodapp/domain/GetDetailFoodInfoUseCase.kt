package com.example.foodapp.domain

class GetDetailFoodInfoUseCase(private val repository: FoodRepository) {
    operator fun invoke(foodId: Int) = repository.getDetailInfo(foodId)
}