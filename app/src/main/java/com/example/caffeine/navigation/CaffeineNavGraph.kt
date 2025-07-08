package com.example.caffeine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.appNavGraph(navController: NavController) {
    onboardingGraph(navController)
    homeScreenNavGraph(navController)
    customizationCoffeeScreenNavGraph(navController)
    coffeeOrderFinishNavGraph(navController)
    takeYourSnackNavGraph(navController)
    confirmationCoffeeOrderNavGraph(navController)
}