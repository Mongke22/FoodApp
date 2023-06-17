package com.example.foodapp.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapp.data.database.model.FoodDbModel

@Dao
interface FoodInfoDao {
    @Query("SELECT * FROM foods")
    fun getFoodInfoList(): LiveData<List<FoodDbModel>>

    @Query("SELECT * FROM foods WHERE id == :getId LIMIT 1")
    suspend fun getFoodInfo(getId: Int): FoodDbModel

    @Query("SELECT COUNT(*) FROM foods where id == :getId")
    fun checkFoodExists(getId: Int): Int

    @Query("UPDATE foods SET picture = :imgSrc WHERE id == :theId")
    suspend fun updateImagePath(imgSrc: String, theId: Int): Int

    @Query("UPDATE foods SET instructions = :theInstructions WHERE id == :theId")
    suspend fun updateInstructions(theInstructions: String, theId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFoodInfo(food: FoodDbModel)
}