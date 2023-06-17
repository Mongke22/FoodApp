package com.example.foodapp.domain

class GetAllCategoriesUseCase(private val repository: FoodRepository) {
    operator fun invoke() = repository.getCategories()
}