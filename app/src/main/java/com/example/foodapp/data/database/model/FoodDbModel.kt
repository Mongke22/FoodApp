package com.example.foodapp.data.database.model

import androidx.room.Entity

@Entity(tableName = "foods")
data class FoodDbModel(
    val id: Int,
    val picture: String,
    val instructions: String,
    val name: String
)
