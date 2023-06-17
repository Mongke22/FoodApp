package com.example.foodapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onStart() {
        Navigator.activity = this
        Navigator.showFoodList()
        super.onStart()
    }

    override fun onStop() {
        Navigator.activity = null
        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

}