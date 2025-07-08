package com.example.caffeine.screen.customizationCoffee

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caffeine.screen.coffeeOrderFinish.component.BeanVisibilityGroup
import com.example.caffeine.screen.customizationCoffee.component.AnimatedTopPar
import com.example.caffeine.screen.customizationCoffee.component.CoffeeAlmostDoneMessage
import com.example.caffeine.screen.customizationCoffee.component.CoffeeCupDisplay
import com.example.caffeine.screen.customizationCoffee.component.CoffeeOptionsSection
import com.example.caffeine.screen.customizationCoffee.component.SnakeLoadingAnimation

@Composable
fun CustomizationCoffeeScreen(
    title: String,
    onNavigateToBack: () -> Unit = {},
    onNavigateToFinishOrder: () -> Unit,
    viewModel: CustomizationCoffeeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CustomizationCoffeeScreenContent(
        title = title,
        uiState = uiState,
        onNavigateToBack = onNavigateToBack,
        onSizeSelected = viewModel::onSizeSelected,
        onIntensitySelected = viewModel::onIntensitySelected,
        onContinueClicked = viewModel::onContinueClicked,
        onNavigateToFinishOrder = onNavigateToFinishOrder,
        setShowTopBar = viewModel::setShowTopBar
    )
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun CustomizationCoffeeScreenContent(
    title: String,
    onNavigateToBack: () -> Unit = {},
    uiState: CustomizationCoffeeUIState,
    onSizeSelected: (CupSize) -> Unit = {},
    onIntensitySelected: (CoffeeIntensity) -> Unit = {},
    onContinueClicked: () -> Unit = {},
    onNavigateToFinishOrder: () -> Unit,
    setShowTopBar: () -> Unit
) {
    val animatedCupHeight by animateDpAsState(
        targetValue = uiState.sizeSelected.height, animationSpec = tween(durationMillis = 500)
    )

    val animatedIconSize by animateDpAsState(
        targetValue = uiState.sizeSelected.iconSize, animationSpec = tween(durationMillis = 500)

    )
    val selectedText = uiState.sizeSelected.volumeMl

    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(), contentAlignment = Alignment.Center
    ) {

        val beanState = uiState.beanAnimationState

        BeanVisibilityGroup(
            isLowSelected = beanState.isLowSelected,
            isMediumSelected = beanState.isMediumSelected,
            isHighSelected = beanState.isHighSelected,
            beanSize = uiState.beansSize
        )
    }

    setShowTopBar()
    Box(
        modifier = Modifier.padding(16.dp)
            .fillMaxSize(),
    ) {
        AnimatedVisibility(
            visible = uiState.showTopBar, enter = slideIn(
                initialOffset = { fullSize ->
                    IntOffset(x = fullSize.width / 3, y = fullSize.height * 8)
                }, animationSpec = tween(durationMillis = 1000)
            ), exit = slideOut(
                targetOffset = { fullSize ->
                    IntOffset(x = fullSize.width, y = -fullSize.height / 2)
                }, animationSpec = tween(durationMillis = 500)
            )
        ) {
            AnimatedTopPar(
                title = title,
                visible = uiState.continueEnabled,
                onNavigateToBack = onNavigateToBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize().padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CoffeeCupDisplay(
            selectedText = selectedText,
            height = animatedCupHeight,
            iconSize = animatedIconSize,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        CoffeeOptionsSection(
            visible = uiState.continueEnabled,
            onSizeSelected = onSizeSelected,
            onIntensitySelected = onIntensitySelected,
            onContinueClicked = onContinueClicked,
            showTopBar = uiState.showTopBar,
        )

        Spacer(modifier = Modifier.weight(1f))

        if (uiState.showLoading) {
            SnakeLoadingAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                color = Color.Black,
                strokeWidth = 6f,
                waveAmplitude = 30f,
                waveFrequency = 0.03f,
                onAnimationFinished = onNavigateToFinishOrder
            )
        }
        CoffeeAlmostDoneMessage(visible = uiState.showLoading)
    }
}