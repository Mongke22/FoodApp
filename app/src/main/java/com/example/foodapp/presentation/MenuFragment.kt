package com.example.foodapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.databinding.MenuFragmentBinding
import com.example.foodapp.presentation.recycler.CategoryAdapter

class MenuFragment : Fragment() {
    companion object {
        fun newInstance() = MenuFragment()
    }

    private var _binding: MenuFragmentBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentBinding is null")
    private val viewModel by lazy { ViewModelProvider(requireActivity())[FoodListViewModel::class.java] }

    private lateinit var categoriesAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MenuFragmentBinding.inflate(layoutInflater)
        loadData()
        return binding.root
    }

    private fun loadData(){

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setupRecyclers()
    }

    private fun observeData(){
        viewModel.categoriesList.observe(viewLifecycleOwner){ categories ->
            categoriesAdapter.submitList(categories)
        }
    }

    private fun setupRecyclers(){
        with(binding){
            categoriesAdapter = CategoryAdapter()
            categoriesRV.adapter = categoriesAdapter
        }
    }

}