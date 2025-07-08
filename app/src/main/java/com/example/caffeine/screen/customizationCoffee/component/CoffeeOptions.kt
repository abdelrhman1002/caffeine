package com.example.caffeine.screen.customizationCoffee.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.composable.CoffeeIntensitySelector
import com.example.caffeine.composable.CoffeeSizeSelector
import com.example.caffeine.composable.MyCoffeeButton
import com.example.caffeine.screen.customizationCoffee.CoffeeIntensity
import com.example.caffeine.screen.customizationCoffee.CupSize


@Composable
internal fun CoffeeOptionsSection(
    visible: Boolean,
    onSizeSelected: (CupSize) -> Unit,
    onIntensitySelected: (CoffeeIntensity) -> Unit,
    onContinueClicked: () -> Unit,
    showTopBar: Boolean,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(durationMillis = 1000)),
        exit = fadeOut(tween(durationMillis = 1000))
    ) {
        Column(modifier = modifier) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                CoffeeSizeSelector(
                    onSizeSelected = onSizeSelected
                )
            }
            CoffeeIntensitySelector(
                onLevelSelected = { coffeeIntensity ->
                    onIntensitySelected(coffeeIntensity)
                })

            Spacer(modifier = Modifier.weight(1f))
            AnimatedVisibility(
                visible = showTopBar,
                enter = slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 1000)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(durationMillis = 1000)
                )
            ) {
                MyCoffeeButton(
                    text = "Continue",
                    icon = R.drawable.arrow_right_04,
                    onClick = onContinueClicked
                )
            }
        }
    }
}