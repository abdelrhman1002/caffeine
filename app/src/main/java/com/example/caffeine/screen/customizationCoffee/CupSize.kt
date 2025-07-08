package com.example.caffeine.screen.customizationCoffee

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class CupSize(
    val height: Dp,
    val iconSize: Dp,
    val volumeMl: String,
) {
    S(200.dp, 40.dp, "150 ml"),
    M(250.dp, 66.dp, "200 ml"),
    L(300.dp, 66.dp, "400 ml"),
}