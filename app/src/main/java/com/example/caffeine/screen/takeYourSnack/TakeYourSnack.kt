package com.example.caffeine.screen.takeYourSnack

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caffeine.R
import com.example.caffeine.composable.TopBarAppIcon
import com.example.caffeine.data.sweat
import com.example.caffeine.composable.customShadow
import com.example.caffeine.ui.theme.primaryColor
import com.example.caffeine.ui.theme.urbanistFontFamily
import kotlin.math.abs

@Composable
fun TakeYourSnack(
    onSweatPressed: (Int) -> Unit = {},
    onBackPress: () -> Unit = {},
    viewModel: TakeYourSnackViewModel = viewModel()
) {
    val selectedPage by viewModel.selectedPage.collectAsState()
    val pagerState = rememberPagerState(pageCount = { sweat.size }, initialPage =selectedPage)

    TakeYourSnackContent(
        pagerState = pagerState, onSweatPressed = onSweatPressed, onBackPress = onBackPress
    )
}

@Composable
fun TakeYourSnackContent(
    pagerState: PagerState,
    onSweatPressed: (Int) -> Unit,
    onBackPress: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBarAppIcon(
                appIcon = R.drawable.cancel_01,
                onClick = onBackPress,
                modifier = Modifier.align(Alignment.Start)
            )

            Text(
                "Take your snack", style = TextStyle(
                    fontFamily = urbanistFontFamily,
                    fontSize = 22.sp,
                    color = primaryColor.copy(alpha = 0.87f),
                    lineHeight = 32.sp,
                    letterSpacing = 0.25.sp,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center,
                ), modifier = Modifier.align(Alignment.Start).padding(top = 24.dp)
            )

            SweatPager(pagerState = pagerState, onItemClick = onSweatPressed)
        }
    }
}
@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun SweatPager(
    pagerState: PagerState,
    onItemClick: (Int) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    VerticalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .offset(x = -screenWidth * 0.25f),
        contentPadding = PaddingValues(vertical = screenHeight * 0.25f),
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(400)
        )
    ) { page ->

        val pageOffset =
            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = when {
            abs(pageOffset) < 0.001f -> 1f
            pageOffset < -1f -> 0.9f.coerceAtLeast(1f - (0.1f * abs(pageOffset)))
            pageOffset < 0f -> 1f - (0.1f * abs(pageOffset))
            else -> 1f - (0.2f * abs(pageOffset))
        }

        val rotation = when {
            abs(pageOffset) < 0.1f -> 2f
            pageOffset < -1f -> lerp(
                -4f * -1f,
                -4f * -2f,
                (pageOffset + 1f) / -1f
            )
            pageOffset < 0f -> -12f * pageOffset
            else -> -10f * pageOffset
        }

        val offsetX = when {
            pageOffset < -1f -> lerp(
                screenWidth.value * 0.4f * -1f,
                screenWidth.value * 0.8f * -2f,
                (pageOffset + 1f) / -1f
            )
            pageOffset < 0f -> screenWidth.value * 0.4f * pageOffset
            else -> -screenWidth.value * 0.2f * pageOffset
        }

        val offsetY = when {
            pageOffset < -1f -> lerp(
                screenHeight.value * 0.06f * -1f,
                screenHeight.value * 0.5f * -2f,
                (pageOffset + 1f) / -1f
            )
            pageOffset < 0f -> screenHeight.value * 0.15f * pageOffset
            else -> screenHeight.value * 0.6f * pageOffset
        }
        val pageIndexDiff = page - pagerState.currentPage

        val photoScale = when (pageIndexDiff) {
            0 -> 0.8f
            -1 -> 1f
            -2 -> 0.7f
            1 -> 0.9f
            2 -> 0.85f
            else -> 0.8f
        }

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    rotationZ = rotation
                    translationX = offsetX
                    translationY = offsetY
                }
                .defaultMinSize(
                    minWidth = screenWidth * 0.7f,
                    minHeight = screenHeight * 0.375f
                )
                .customShadow()
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(32.dp)
                )
                .clickable (
                    onClick = { onItemClick(sweat[page]) },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(sweat[page]),
                contentDescription = "Sweat ${page + 1}",
                modifier = Modifier.size(screenWidth * 0.6f * photoScale)
            )
        }
    }
}


