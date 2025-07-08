package com.example.caffeine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.caffeine.screen.customizationCoffee.CustomizationCoffeeScreen

fun NavGraphBuilder.customizationCoffeeScreenNavGraph(navController: NavController) {
    composable<Screen.CustomizationCoffeeScreen> { entry ->
        val args = entry.toRoute<Screen.CustomizationCoffeeScreen>()
        CustomizationCoffeeScreen(
            title = args.title,
            onNavigateToBack = { navController.navigateUp() },
            onNavigateToFinishOrder = { navController.navigate(Screen.CoffeeOrderFinish) }
        )
    }
}