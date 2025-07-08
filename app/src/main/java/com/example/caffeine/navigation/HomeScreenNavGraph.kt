package com.example.caffeine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.caffeine.screen.homeScreen.HomeScreen

fun NavGraphBuilder.homeScreenNavGraph(navController: NavController) {
    composable<Screen.HomeScreen> {
        HomeScreen(
            onClickContinue = { title ->
                navController.navigate(Screen.CustomizationCoffeeScreen(title))
            }
        )
    }
}