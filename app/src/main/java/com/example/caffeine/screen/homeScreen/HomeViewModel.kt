package com.example.caffeine.screen.homeScreen

import androidx.lifecycle.ViewModel
import com.example.caffeine.data.DrinkItem
import com.example.caffeine.data.drinkList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _drinks = MutableStateFlow(drinkList)
    val drinks: StateFlow<List<DrinkItem>> = _drinks

    private val _selectedDrinkIndex = MutableStateFlow(0)
    val selectedDrinkIndex: StateFlow<Int> = _selectedDrinkIndex

    fun onDrinkSelected(index: Int) {
        _selectedDrinkIndex.value = index
    }
}