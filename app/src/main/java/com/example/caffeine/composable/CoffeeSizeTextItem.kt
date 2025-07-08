package com.example.caffeine.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.White
import com.example.caffeine.ui.theme.primaryColor

@Composable
fun CoffeeSizeTextItem(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val boxAlpha by animateFloatAsState(
        animationSpec = TweenSpec(durationMillis = 800), targetValue = if (isSelected) 1f else 0f
    )

    val animatedTextColor by animateColorAsState(
        animationSpec = TweenSpec(durationMillis = 800),
        targetValue = if (isSelected) White.copy(alpha = 0.87f) else primaryColor.copy(alpha = 0.6f),
    )
    val shadowAnimationSpec = if (isSelected)
        tween(durationMillis = 200, delayMillis = 150)
     else
        tween<Float>(durationMillis = 500)


    val shadowAlpha by animateFloatAsState(
            targetValue = if (isSelected) 1f else 0f,
            animationSpec = shadowAnimationSpec
        )

    val textStyle = TextStyle(
        fontSize = 20.sp, fontWeight = FontWeight(700), letterSpacing = 0.25.sp
    )
    val interactionSource = remember { MutableInteractionSource() }
    val boxColor = Color(0xFF7C351B).copy(alpha = boxAlpha)
    Box(
        modifier = modifier
            .defaultMinSize(40.dp, 40.dp)
            .circleShadow(
                isSelected = isSelected,
                shadowRadius = 36f,
                offsetY = 20f,
                alpha = shadowAlpha,
            )
            .background(
                color = boxColor, shape = CircleShape
            )
            .clickable(
                interactionSource = interactionSource, indication = null, onClick = onClick
            ), contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, style = textStyle, color = animatedTextColor
        )
    }
}