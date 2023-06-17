package com.example.foodapp.presentation.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R

class FoodViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private var name: TextView = view.findViewById(R.id.foodName)
    private var picture: ImageView = view.findViewById(R.id.foodImage)
    private var description: TextView = view.findViewById(R.id.foodDescription)
    private var price: TextView = view.findViewById(R.id.foodPrice)

    fun setName(foodName: String){
        name.text = foodName
    }

    fun setPicture(path: String){
    }

    fun setDescription(text: String){
    }

    fun setPrice(foodPrice: Int){
    }
}