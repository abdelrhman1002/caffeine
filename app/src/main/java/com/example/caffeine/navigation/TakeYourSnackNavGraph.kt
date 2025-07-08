package com.example.caffeine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.caffeine.screen.takeYourSnack.TakeYourSnack

fun NavGraphBuilder.takeYourSnackNavGraph(navController: NavController) {
    composable<Screen.TakeYourSnack> {
        TakeYourSnack(onSweatPressed = { image ->
            navController.navigate(Screen.ConfirmationCoffeeOrder(image))
        }, onBackPress = { navController.popBackStack() })
    }
}