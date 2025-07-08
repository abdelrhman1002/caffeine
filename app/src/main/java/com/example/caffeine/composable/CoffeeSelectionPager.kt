package com.example.caffeine.composable

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.caffeine.data.DrinkItem
import kotlin.math.abs

@Composable
fun CoffeeSelectionPager(
    drinkList: List<DrinkItem>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 56.dp),
        contentPadding = PaddingValues(horizontal = 90.dp),
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(durationMillis = 800),
        )
    ) { page ->
        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
        val scale = 1f - (0.40f * abs(pageOffset))
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
      ) {
            CoffeeItem(
                name = drinkList[page].title,
                imageRes = drinkList[page].imageRes,
            )
        }
    }
}