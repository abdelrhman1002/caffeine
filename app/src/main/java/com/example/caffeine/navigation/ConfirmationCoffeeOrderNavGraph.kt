package com.example.caffeine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.caffeine.screen.confirmationCoffeeOrder.ConfirmationCoffeeOrder

fun NavGraphBuilder.confirmationCoffeeOrderNavGraph(navController: NavController) {
    composable<Screen.ConfirmationCoffeeOrder> { entry->
        val args = entry.toRoute<Screen.ConfirmationCoffeeOrder>()
        ConfirmationCoffeeOrder(
            onNavigateToBack = { navController.popBackStack() },
            onNavigateToHome = {navController.navigateToHome()},
            image = args.image
        )
    }
}

fun NavController.navigateToHome() {
    this.navigate(Screen.OnboardingScreen) {
        popUpTo(0) { inclusive = true }
        launchSingleTop = true
    }
}