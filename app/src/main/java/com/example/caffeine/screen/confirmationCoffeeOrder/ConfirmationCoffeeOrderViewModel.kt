package com.example.caffeine.screen.confirmationCoffeeOrder

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ConfirmationCoffeeOrderViewModel : ViewModel() {
    private val _animateImage = mutableStateOf(false)
    val animateImage = _animateImage

    init {
        startAnimation()
    }

    private fun startAnimation() {
        viewModelScope.launch {
            delay(100)
            _animateImage.value = true
        }
    }
}