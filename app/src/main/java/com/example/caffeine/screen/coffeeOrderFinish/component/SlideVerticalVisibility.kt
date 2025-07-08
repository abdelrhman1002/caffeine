package com.example.caffeine.screen.coffeeOrderFinish.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SlideVerticalVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    initialOffsetY: (Int) -> Int = { fullHeight -> -fullHeight * 4 },
    targetOffsetY: (Int) -> Int = { fullHeight -> -fullHeight * 3 },
    durationMillis: Int = 2000,
    enterDelay: Int = 0,
    exitDelay: Int = 0,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth(), contentAlignment = alignment
    ) {
        AnimatedVisibility(
            visible = visible, enter = slideInVertically(
                initialOffsetY = initialOffsetY, animationSpec = tween(
                    durationMillis = durationMillis, delayMillis = enterDelay
                )
            ), exit = slideOutVertically(
                targetOffsetY = targetOffsetY, animationSpec = tween(
                    durationMillis = durationMillis, delayMillis = exitDelay
                )
            )
        ) {
            content()
        }
    }
}