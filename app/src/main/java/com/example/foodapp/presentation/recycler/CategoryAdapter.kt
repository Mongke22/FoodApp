package com.example.foodapp.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.foodapp.R
import com.example.foodapp.domain.model.Category
import com.example.foodapp.domain.model.Food

class CategoryAdapter : ListAdapter<Category, CategoryViewHolder>(CategoryDiffUtilCallBack()) {

    var wordItemOnClickListener: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.setName(category.name)
        holder.view.setOnClickListener{
            wordItemOnClickListener?.invoke(category)
        }
    }
}

class CategoryDiffUtilCallBack: DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}