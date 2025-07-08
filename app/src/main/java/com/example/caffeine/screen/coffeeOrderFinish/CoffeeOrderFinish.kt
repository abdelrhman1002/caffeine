package com.example.caffeine.screen.coffeeOrderFinish

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caffeine.R
import com.example.caffeine.composable.MyCoffeeButton
import com.example.caffeine.composable.TopBarAppIcon
import com.example.caffeine.composable.circleShadow
import com.example.caffeine.screen.coffeeOrderFinish.component.AnimatedCoffeeCupPair
import com.example.caffeine.screen.coffeeOrderFinish.component.AnimatedSwitchButton
import com.example.caffeine.screen.coffeeOrderFinish.component.SlideVerticalVisibility
import com.example.caffeine.ui.theme.primaryColor
import com.example.caffeine.ui.theme.urbanistFontFamily

@Composable
fun CoffeeOrderFinish(
    onCancelClicked: () -> Unit = {},
    onContinuePress: () -> Unit = {},
    viewModel: CoffeeOrderFinishViewModel = viewModel()
) {
    val isScreenVisible = viewModel.isScreenVisible.value
    LaunchedEffect(Unit) {
        viewModel.showScreen(true)
    }
    CoffeeOrderFinishContent(
        isScreenVisible = isScreenVisible,
        onCancelClicked = onCancelClicked,
        onContinuePress = onContinuePress
    )
}

@Composable
fun CoffeeOrderFinishContent(
    isScreenVisible: Boolean, onCancelClicked: () -> Unit = {}, onContinuePress: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SlideVerticalVisibility(
            visible = isScreenVisible,
            alignment = Alignment.TopStart,
        ) {
            TopBarAppIcon(
                appIcon = R.drawable.cancel_01, onClick = onCancelClicked
            )
        }

        val shadowColor = Color(0x80894B23)

        SlideVerticalVisibility(
            visible = isScreenVisible,
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .defaultMinSize(56.dp, 56.dp)
                    .circleShadow(
                        shadowColor = shadowColor,
                        shadowRadius = 24f,
                        offsetY = 12f,
                        alpha = 1f,
                        circleSizeRatio = 1.9f
                    )
                    .background(
                        color = Color(0xFF7C351B), shape = CircleShape
                    ), contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.tick_02),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        SlideVerticalVisibility(
            visible = isScreenVisible,
        ) {
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = "Your coffee is ready,\n" + "Enjoy",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color(0xFF333333),
                    lineHeight = 32.sp,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = urbanistFontFamily,
                    fontWeight = FontWeight(700)
                )
            )
        }

        AnimatedCoffeeCupPair(
            isVisible = isScreenVisible, modifier = Modifier.padding(top = 18.dp)
        )

        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AnimatedSwitchButton()
            Text(
                "Take Away", style = TextStyle(
                    fontFamily = urbanistFontFamily,
                    fontWeight = FontWeight(700),
                    fontSize = 14.sp,
                    color = primaryColor.copy(0.7f),
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center,
                )
            )
        }
        SlideVerticalVisibility(
            visible = isScreenVisible, initialOffsetY = { height -> height }) {
            MyCoffeeButton(
                "Take snack",
                icon = R.drawable.arrow_right_04,
                modifier = Modifier.padding( top = 16.dp),
                onClick = onContinuePress
            )
        }
    }
}