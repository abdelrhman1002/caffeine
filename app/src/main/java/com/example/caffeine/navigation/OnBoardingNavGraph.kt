package com.example.caffeine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.caffeine.screen.onBoarding.OnBoardingScreen

fun NavGraphBuilder.onboardingGraph(navController: NavController) {
    composable<Screen.OnboardingScreen>{
        OnBoardingScreen(
            onNavigateToHome = {
                navController.navigate(Screen.HomeScreen)
            }
        )
    }
}