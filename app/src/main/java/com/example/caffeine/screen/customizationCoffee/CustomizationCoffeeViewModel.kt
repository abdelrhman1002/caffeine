package com.example.caffeine.screen.customizationCoffee

import android.annotation.SuppressLint
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CustomizationCoffeeViewModel : ViewModel(), CustomizationCoffeeInteractions {
    private val _uiState = MutableStateFlow(CustomizationCoffeeUIState())
    val uiState: StateFlow<CustomizationCoffeeUIState> = _uiState.asStateFlow()

    @SuppressLint("SuspiciousIndentation")
    override fun onSizeSelected(size: CupSize) {
        _uiState.value = _uiState.value.copy(sizeSelected = size)
            getBeansSize(size)
    }

    override fun onIntensitySelected(currentIntensity: CoffeeIntensity) {
        val previous = _uiState.value.intensitySelected

        val dropBeans = previous.volume < currentIntensity.volume

        val beanState = BeanAnimationState(
            dropBeans = dropBeans,
            isLowSelected = currentIntensity.volume == CoffeeIntensity.LOW.volume,
            isMediumSelected = currentIntensity.volume == CoffeeIntensity.MEDIUM.volume,
            isHighSelected = currentIntensity.volume == CoffeeIntensity.HIGH.volume
        )

        _uiState.update { currentState ->
            currentState.copy(
                previousSelectedIntensity = previous,
                intensitySelected = currentIntensity,
                beanAnimationState = beanState
            )
        }
    }

    override fun onContinueClicked() {
        val isContinuing = !_uiState.value.continueEnabled
        _uiState.value = _uiState.value.copy(continueEnabled = isContinuing)

        if (!isContinuing) {
            viewModelScope.launch {
                delay(1000)
                _uiState.value = _uiState.value.copy(showLoading = true)
            }
        } else {
            _uiState.value = _uiState.value.copy(showLoading = false)
        }
    }

    fun setShowTopBar() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(showTopBar = true)
        }
    }
  private fun getBeansSize(size : CupSize){
        when (size.name) {
            "S" -> {
                _uiState.value = _uiState.value.copy(beansSize = 125.dp)
            }
            "M" -> {
                _uiState.value = _uiState.value.copy(beansSize = 140.dp)
            }
            "L" -> {
                _uiState.value = _uiState.value.copy(beansSize = 175.dp)
            }
        }
    }
}