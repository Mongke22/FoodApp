package com.example.foodapp.presentation

import com.example.foodapp.R

object Navigator {
    var activity: ScrollingActivity? = null


    fun showDetailFoodInfo(id: Long) {

    }

    fun showFoodList() {
        activity!!.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, MenuFragment.newInstance())
            .commit()
    }

    fun moveBack() {
        activity!!.supportFragmentManager.popBackStack()
    }
}