package com.example.caffeine.screen.customizationCoffee

interface CustomizationCoffeeInteractions {
    fun onSizeSelected(size: CupSize)
    fun onIntensitySelected(currentIntensity: CoffeeIntensity)
    fun onContinueClicked()
}