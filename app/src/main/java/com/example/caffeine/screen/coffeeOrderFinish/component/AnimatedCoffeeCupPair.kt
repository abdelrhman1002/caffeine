package com.example.caffeine.screen.coffeeOrderFinish.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R


@Composable
internal fun AnimatedCoffeeCupPair(
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    animationDuration: Int = 2000,
    topCupResId: Int = R.drawable.top_cup,
    mainCupResId: Int = R.drawable.empty_cup,
    iconResId: Int = R.drawable.the_chance_icon
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 18.dp)
            .height(341.dp)
    ) {
        AnimatedVisibility(
            visible = isVisible, enter = fadeIn(tween(1500)), exit = fadeOut(tween(1500))
        ) {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = mainCupResId),
                    contentDescription = "Cup of Coffee",
                    modifier = Modifier.height(300.dp)
                )
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
        AnimatedVisibility(
            visible = isVisible, enter = slideInVertically(
                initialOffsetY = { fullHeight -> -(fullHeight * 5) },
                animationSpec = tween(durationMillis = animationDuration)
            ), exit = slideOutVertically(
                targetOffsetY = { fullHeight -> fullHeight },
                animationSpec = tween(durationMillis = animationDuration)
            ), modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = (-20).dp)
        ) {
            Image(
                painter = painterResource(topCupResId),
                contentDescription = "TopCup",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            )
        }
    }
}
