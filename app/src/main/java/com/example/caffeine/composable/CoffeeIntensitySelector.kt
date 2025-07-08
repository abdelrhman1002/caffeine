package com.example.caffeine.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.screen.customizationCoffee.CoffeeIntensity
import com.example.caffeine.ui.theme.primaryColor
import com.example.caffeine.ui.theme.urbanistFontFamily

@Composable
fun CoffeeIntensitySelector(
    modifier: Modifier = Modifier,
    intensityLevels: List<CoffeeIntensity> = CoffeeIntensity.entries,
    onLevelSelected: (CoffeeIntensity) -> Unit = {}
) {
    var selectedLevel by remember { mutableStateOf(CoffeeIntensity.LOW) }

    Column(
        modifier = modifier.padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .background(color = Color(0xFFF5F5F5), shape = CircleShape)
                .padding(horizontal = 8.dp , vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            intensityLevels.forEach { level ->
                CoffeeIntensityTextItem(
                    isSelected = level == selectedLevel,
                    onClick = {
                        selectedLevel = level
                        onLevelSelected(level)
                    }
                )
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 2.dp)
                .fillMaxWidth(0.35f),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            intensityLevels.forEach {
                Text(
                    text = it.name,
                    fontSize = 10.sp,
                    letterSpacing = (0.25).sp,
                    fontFamily = urbanistFontFamily,
                    fontWeight = FontWeight(500),
                    color = primaryColor.copy(alpha = 0.6f)
                )
            }
        }
    }
}
@Composable
fun CoffeeIntensityTextItem(
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val boxAlpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    val shadowAnimationSpec = if (isSelected)
        tween(durationMillis = 200, delayMillis = 150)
    else
        tween<Float>(durationMillis = 500)

    val shadowAlpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else 0f,
        animationSpec = shadowAnimationSpec
    )

    val iconAlpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    val boxColor = Color(0xFF7C351B).copy(alpha = boxAlpha)
    val shadowColor = Color(0x80894B23)
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .defaultMinSize(40.dp, 40.dp)
            .circleShadow(
                isSelected = isSelected,
                shadowColor = shadowColor,
                shadowRadius = 36f,
                offsetY = 20f,
                alpha = shadowAlpha,
            )
            .clip(CircleShape)
            .background(boxColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.coffee_beans),
            contentDescription = null,
            tint = Color.White.copy(alpha = iconAlpha),
            modifier = Modifier
                .alpha(iconAlpha)
        )
    }
}