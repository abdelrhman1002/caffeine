package com.example.caffeine.screen.takeYourSnack

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TakeYourSnackViewModel : ViewModel() {
    private val _selectedPage = MutableStateFlow(1)
    val selectedPage: StateFlow<Int> = _selectedPage

    fun updateSelectedPage(index: Int) {
        _selectedPage.value = index
    }
}