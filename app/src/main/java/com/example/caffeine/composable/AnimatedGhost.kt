package com.example.caffeine.composable

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun AnimatedGhost(modifier: Modifier = Modifier) {
 val infiniteTransition = rememberInfiniteTransition()

    val offsetGhost by infiniteTransition.animateValue(
        initialValue = -30.dp,
        targetValue = 0.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1750),
            repeatMode = RepeatMode.Reverse
        ),
    )
    Image(
        painter = painterResource(id = R.drawable.ghost),
        contentDescription = "ghost",
        modifier = modifier
            .padding(horizontal = 58.dp).padding(top = 33.dp)
            .offset(y = offsetGhost)
    )

    val offsetShadowGhostOffset by infiniteTransition.animateValue(
        initialValue = 5.dp,
        targetValue = 0.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1750),
            repeatMode = RepeatMode.Reverse
        ),
    )
    val offsetShadowGhostAlpha by infiniteTransition.animateFloat(
        initialValue = 0.150f,
        targetValue = 0.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1750),
            repeatMode = RepeatMode.Reverse
        ),
    )

    Icon(
        modifier = modifier
            .offset(y = offsetShadowGhostOffset)
            .blur(radius = 12.dp).padding(top = 2.5.dp)
            .fillMaxWidth(),
        contentDescription = "ghost",
        imageVector = ImageVector.vectorResource(id = R.drawable.ellipse_92),
        tint = Color.Unspecified.copy(offsetShadowGhostAlpha)
    )
}