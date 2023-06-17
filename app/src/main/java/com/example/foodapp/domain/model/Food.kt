package com.example.foodapp.domain.model

data class Food(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    var imagePath: String,
    var instructions: String,
)
