package com.example.caffeine.screen.coffeeOrderFinish.component

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.White
import com.example.caffeine.ui.theme.primaryColor
import com.example.caffeine.ui.theme.urbanistFontFamily

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun AnimatedSwitchButton(
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    var isClicked by remember { mutableStateOf(false) }
    val imageOffset by animateDpAsState(
        targetValue = if (isClicked) -(38).dp else 0.dp, animationSpec = tween(durationMillis = 800)
    )


    val boxColor by animateColorAsState(
        if (isClicked) Color(0xFF7C351B) else Color(0xFFFFEEE7),

        animationSpec = tween(durationMillis = 800)
    )
    Box(
        modifier = modifier
            .width(78.dp)
            .height(40.dp)
            .clip(CircleShape)
            .background(boxColor)
            .clickable(
                onClick = { isClicked = !isClicked },
                indication = null,
                interactionSource = interactionSource
            )
    ) {
        Text(
            "OFF", style = TextStyle(
                color = primaryColor.copy(0.6f),
                fontFamily = urbanistFontFamily,
                fontWeight = FontWeight(700),
                fontSize = 10.sp,
                letterSpacing = (0.25).sp,
                textAlign = TextAlign.Center,
            ), modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 14.dp, top = 2.dp)
        )

        Text(
            "ON", style = TextStyle(
                color = White.copy(alpha = 0.6f),
                fontFamily = urbanistFontFamily,
                fontWeight = FontWeight(700),
                fontSize = 10.sp,
                letterSpacing = (0.25).sp,
                textAlign = TextAlign.Center,
            ), modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 14.dp, top = 2.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.swicth_button_icon),
            contentDescription = null,
            modifier = Modifier
                .offset(x = imageOffset)
                .align(Alignment.CenterEnd)
        )
    }
}
