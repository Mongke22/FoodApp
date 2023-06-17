package com.example.foodapp.data

import com.example.foodapp.data.database.model.FoodDbModel
import com.example.foodapp.data.network.model.FoodInfoDto
import com.example.foodapp.data.network.model.MealDto
import com.example.foodapp.domain.model.Food

class Mapper {
    fun mapFoodInfoDtoToDbModel(food: MealDto): FoodDbModel {
        return FoodDbModel(food.foodId, food.foodPicture, "", food.foodName)
    }

    fun mapDbModelToEntity(foodDb: FoodDbModel): Food {
        return Food(
            foodDb.id,
            foodDb.name,
            "Любое описание",
            315,
            foodDb.picture,
            foodDb.instructions
        )
    }
}