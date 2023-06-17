package com.example.foodapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import com.example.foodapp.data.database.AppDataBase
import com.example.foodapp.data.network.ApiFactory
import com.example.foodapp.domain.FoodRepository
import com.example.foodapp.domain.model.Category
import com.example.foodapp.domain.model.Food
import kotlinx.coroutines.flow.flow

class FoodRepositoryImpl(application: Application) : FoodRepository {

    private val foodInfoDao = AppDataBase.getInstance(application).foodInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = Mapper()


    private val categories = mutableListOf(
        Category(name = "Beef", isChecked = false),
        Category(name = "Chicken", isChecked = false),
        Category(name = "Dessert", isChecked = false),
        Category(name = "Lamb", isChecked = false),
        Category(name = "Pasta", isChecked = false),
    )

    override fun getCategories(): LiveData<List<Category>> {
        return flow {
            emit(categories.toList())
        }.asLiveData()
    }

    override suspend fun getMenuByCategoryName(categoryName: String): List<Food> {
        for (food in apiService.getFoodListByCategory(categoryName).meals) {
            foodInfoDao.insertFoodInfo(mapper.mapFoodInfoDtoToDbModel(food))
        }

        return foodInfoDao.getFoodInfoList().map { foodDb ->
                mapper.mapDbModelToEntity(foodDb)
            }

    }

    override suspend fun getDetailInfo(foodId: Int): Food {
        foodInfoDao.updateInstructions(
            apiService.getFoodDetailInfo(foodId).foodInfo[0].foodInstructions,
            foodId
        )

        return mapper.mapDbModelToEntity(foodInfoDao.getFoodInfo(foodId))
    }
}