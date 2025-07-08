package com.example.caffeine.screen.coffeeOrderFinish.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
internal fun AnimatedBean(
    modifier: Modifier = Modifier,
    visible: Boolean,
    offsetY: Dp,
    beansSize: Dp
) {
    val animatedSize by animateDpAsState(
        targetValue = beansSize, animationSpec = tween(350)
    )

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = tween(
            1500
        ), initialOffsetY = { -it * 2 }) + fadeIn(
            animationSpec = tween(
                1500
            )
        ) + scaleIn(tween(1500)),
        exit = slideOutVertically(
            animationSpec = tween(1500),
            targetOffsetY = { (-it * 2) }),
        modifier = modifier
            .height(300.dp)
            .offset(y = offsetY)
    ) {
        Image(
            painter = painterResource(R.drawable.beans),
            contentDescription = "High additional beans",
            modifier = Modifier.size(animatedSize)
        )
    }
}