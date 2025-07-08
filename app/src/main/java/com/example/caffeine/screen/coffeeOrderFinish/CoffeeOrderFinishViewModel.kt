package com.example.caffeine.screen.coffeeOrderFinish

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CoffeeOrderFinishViewModel: ViewModel() {
private val _isScreenVisible = mutableStateOf(false)
    val isScreenVisible = _isScreenVisible

    fun showScreen(show: Boolean) {
        _isScreenVisible.value = show
    }
}