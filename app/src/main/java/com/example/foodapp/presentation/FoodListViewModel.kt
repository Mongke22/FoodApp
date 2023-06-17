package com.example.foodapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.FoodRepositoryImpl
import com.example.foodapp.domain.GetAllCategoriesUseCase
import com.example.foodapp.domain.GetDetailFoodInfoUseCase
import com.example.foodapp.domain.GetFoodListByCategory
import com.example.foodapp.domain.model.Category
import com.example.foodapp.domain.model.Food
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodListViewModel(application: Application): AndroidViewModel(application) {
    private val repository = FoodRepositoryImpl(application)
    private val getFoodListByCategory = GetFoodListByCategory(repository)
    private val getAllCategoriesUseCase = GetAllCategoriesUseCase(repository)
    private val getDetailFoodInfoUseCase = GetDetailFoodInfoUseCase(repository)

    private var _foodList = MutableLiveData<List<Food>?>()
    val foodList: LiveData<List<Food>?>
        get() = _foodList

    private var _categoriesList = getAllCategoriesUseCase()
    val categoriesList: LiveData<List<Category>>
        get() = _categoriesList


    fun getFoodItemsByCategory(category: String){
        viewModelScope.launch (Dispatchers.IO){
            val foodList: List<Food> = getFoodListByCategory(category)
            _foodList.postValue(foodList)
        }
    }

}