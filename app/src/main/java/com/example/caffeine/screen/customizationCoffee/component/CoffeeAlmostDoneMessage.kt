package com.example.caffeine.screen.customizationCoffee.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.composable.TextWithVerticalDots
import com.example.caffeine.ui.theme.primaryColor
import com.example.caffeine.ui.theme.urbanistFontFamily


@Composable
internal fun CoffeeAlmostDoneMessage(visible: Boolean) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(tween(durationMillis = 1000)),
        exit = fadeOut(tween(durationMillis = 1000))
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                text = "Almost Done",
                letterSpacing = 0.25f.sp,
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                fontFamily = urbanistFontFamily,
                color = primaryColor.copy(alpha = 0.87f)
            )
            Text(
                text = "Your coffee will be finish in",
                fontFamily = urbanistFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = primaryColor.copy(alpha = 0.6f)
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp) , verticalAlignment = Alignment.CenterVertically) {
                listOf("CO", "FF", "EE").forEach { item ->
                    TextWithVerticalDots(item , withDot = item != "EE")
                }
            }
        }
    }
}