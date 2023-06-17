package com.example.foodapp.presentation.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R

class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private var name: TextView = view.findViewById(R.id.categoryName)

    fun setName(categoryName: String){
        name.text = categoryName
    }
}