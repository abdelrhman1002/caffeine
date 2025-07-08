package com.example.caffeine.screen.customizationCoffee.component
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.TopBarAppIcon
import com.example.caffeine.ui.theme.urbanistFontFamily


@Composable
internal fun AnimatedTopPar(
    title: String,
    modifier: Modifier = Modifier,
    visible: Boolean = true,
    onNavigateToBack: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        AnimatedVisibility(
            visible = visible, enter = slideInVertically(
                animationSpec = tween(durationMillis = 700)
            ) + fadeIn(tween(durationMillis = 500)), exit = slideOutVertically(
                targetOffsetY = { fullHeight -> -(fullHeight * 2) },
                animationSpec = tween(durationMillis = 700)
            ) + fadeOut(tween(durationMillis = 500))
        ) {
            Row(
                modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
            ) {
                TopBarAppIcon(
                    appIcon = R.drawable.back_arrow,
                    modifier = Modifier.padding(end = 12.dp),
                    onClick = onNavigateToBack
                )
                Text(
                    title,
                    fontFamily = urbanistFontFamily,
                    letterSpacing = (0.25).sp,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}
