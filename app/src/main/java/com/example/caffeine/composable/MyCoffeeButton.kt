package com.example.caffeine.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.urbanistFontFamily

@Composable
fun MyCoffeeButton(
    text: String,
    modifier: Modifier = Modifier,
    icon: Int,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .customShadow(
                shadowColor = Color(0xFF000000).copy(alpha = 0.24f),
                shadowRadius = 30f,
                offsetX = 0f,
                offsetY = 15f,
                cornerRadius = 72f
            )
            .background(color = Color(0xFF1F1F1F), shape = CircleShape)
            .padding(vertical = 18.dp, horizontal = 32.dp)
            .clickable { onClick() },
    ) {
        Text(
            text = text,
            fontFamily = urbanistFontFamily,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "coffee",
            tint = Color.White,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
