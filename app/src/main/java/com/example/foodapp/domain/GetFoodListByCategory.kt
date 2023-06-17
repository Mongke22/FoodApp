package com.example.foodapp.domain

class GetFoodListByCategory(private val repository: FoodRepository) {
    operator fun invoke(catName: String) = repository.getMenuByCategoryName(catName)
}