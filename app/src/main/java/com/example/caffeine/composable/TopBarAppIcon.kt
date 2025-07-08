package com.example.caffeine.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TopBarAppIcon(
    appIcon: Int, modifier: Modifier = Modifier, onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .background(color = Color(0xFFF5F5F5), shape = CircleShape)
            .clip(CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(id = appIcon),
            contentDescription = "Settings",
            modifier = Modifier.padding(12.dp)
        )
    }
}