package com.example.foodapp.domain

import androidx.lifecycle.LiveData
import com.example.foodapp.domain.model.Category
import com.example.foodapp.domain.model.Food

interface FoodRepository {

    fun getCategories(): LiveData<List<Category>>

    fun getMenuByCategoryName(categoryName: String): LiveData<List<Food>>

    fun getDetailInfo(foodId: Int): Food
}