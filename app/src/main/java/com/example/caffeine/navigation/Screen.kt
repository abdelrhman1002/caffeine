package com.example.caffeine.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
   data object OnboardingScreen : Screen

    @Serializable
    data object HomeScreen : Screen

    @Serializable
     data class CustomizationCoffeeScreen(val title: String) : Screen

    @Serializable
    data object CoffeeOrderFinish : Screen

    @Serializable
    data object TakeYourSnack : Screen

    @Serializable
    data class ConfirmationCoffeeOrder(val image : Int) : Screen
}