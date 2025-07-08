package com.example.caffeine.screen.coffeeOrderFinish.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun BeanVisibilityGroup(
    isLowSelected: Boolean,
    isMediumSelected: Boolean,
    isHighSelected: Boolean,
    modifier: Modifier = Modifier,
    beanSize: Dp
) {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp

    Box(modifier = modifier) {
        AnimatedBean(
            visible = isLowSelected || isMediumSelected || isHighSelected,
            offsetY = screenHeightDp * 0.1f,
            beansSize = beanSize,
        )

        AnimatedBean(
            visible = isMediumSelected || isHighSelected,
            offsetY = screenHeightDp * 0.1f,
            beansSize = beanSize,
        )

        AnimatedBean(
            visible = isHighSelected,
            offsetY = screenHeightDp * 0.1f,
            beansSize = beanSize,
        )
    }
}