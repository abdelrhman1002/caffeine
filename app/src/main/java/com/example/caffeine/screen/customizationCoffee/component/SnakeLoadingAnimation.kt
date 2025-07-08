package com.example.caffeine.screen.customizationCoffee.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.sin

@Composable
internal fun SnakeLoadingAnimation(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    strokeWidth: Float = 8f,
    waveAmplitude: Float = 50f,
    waveFrequency: Float = 0.08f,
    onAnimationFinished: () -> Unit = {}
) {
    val progress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = 1f, animationSpec = tween(durationMillis = 4000, easing = LinearEasing)
        )
        progress.animateTo(
            targetValue = 0.4f, animationSpec = tween(durationMillis = 4000, easing = LinearEasing)
        )
        onAnimationFinished()
    }
    Canvas(modifier) {
        val path = Path()
        val width = size.width
        val centerY = size.height / 2f
        val endX = (width * progress.value).toInt()

        for (x in 0..endX step 2) {
            val y = centerY + sin(x * waveFrequency) * waveAmplitude
            if (x == 0) path.moveTo(0f, y) else path.lineTo(x.toFloat(), y)
        }
        drawPath(path, color, style = Stroke(strokeWidth))
    }
}