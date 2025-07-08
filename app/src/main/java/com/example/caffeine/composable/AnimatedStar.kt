package com.example.caffeine.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun AnimatedStar(modifier: Modifier = Modifier) {
    val alpha = remember { Animatable(0.3f) }

    LaunchedEffect(Unit) {
        while (true) {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 500)
            )
            delay(150)
            alpha.animateTo(
                targetValue = 0.3f,
                animationSpec = tween(durationMillis = 500)
            )
            delay(150)
        }
    }

    Icon(
        painter = painterResource(id = R.drawable.star),
        contentDescription = "star",
        tint = Color(0xDE1F1F1F),
        modifier = modifier
            .alpha(alpha.value)
    )
}