package com.example.foodapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class FoodDbModel(
    @PrimaryKey
    val id: Int,
    val picture: String,
    val instructions: String,
    val name: String
)
