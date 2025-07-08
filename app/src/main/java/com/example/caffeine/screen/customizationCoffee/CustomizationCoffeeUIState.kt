package com.example.caffeine.screen.customizationCoffee

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CustomizationCoffeeUIState(
    val sizeSelected: CupSize = CupSize.M,
    val intensitySelected: CoffeeIntensity = CoffeeIntensity.LOW,
    val continueEnabled: Boolean = true,
    val previousSelectedIntensity: CoffeeIntensity = CoffeeIntensity.LOW,
    val showTopBar: Boolean = false,
    val showLoading: Boolean = false,
    val beanAnimationState: BeanAnimationState = BeanAnimationState(
        dropBeans = false,
        isLowSelected = false,
        isMediumSelected = false,
        isHighSelected = false
    ),
    val beansSize: Dp = 135.dp
)
data class BeanAnimationState(
    val dropBeans: Boolean,
    val isLowSelected: Boolean,
    val isMediumSelected: Boolean,
    val isHighSelected: Boolean
)
