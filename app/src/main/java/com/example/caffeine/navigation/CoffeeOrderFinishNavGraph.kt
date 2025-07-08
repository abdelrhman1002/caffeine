package com.example.caffeine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.caffeine.screen.coffeeOrderFinish.CoffeeOrderFinish

fun NavGraphBuilder.coffeeOrderFinishNavGraph(navController: NavController) {
    composable<Screen.CoffeeOrderFinish> {
        CoffeeOrderFinish(
            onCancelClicked = { navController.popBackStack() },
            onContinuePress = { navController.navigate(Screen.TakeYourSnack) }
        )
    }
}