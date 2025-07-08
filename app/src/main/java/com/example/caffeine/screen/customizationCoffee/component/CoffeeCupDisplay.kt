package com.example.caffeine.screen.customizationCoffee.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.urbanistFontFamily


@Composable
internal fun CoffeeCupDisplay(
    selectedText: String, height: Dp, iconSize: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 66.dp)
            .padding(horizontal = 16.dp)
            .defaultMinSize(minHeight = 360.dp)
    ) {
        Text(
            selectedText,
            fontFamily = urbanistFontFamily,
            letterSpacing = (0.25).sp,
            fontSize = 14.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF000000),
            modifier = Modifier.offset(y = (64).dp)
        )
        Image(
            painter = painterResource(id = R.drawable.empty_cup),
            contentDescription = "empty cup",
            modifier = Modifier
                .align(Alignment.Center)
                .height(height),
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.the_chance_icon),
            contentDescription = "spoon",
            modifier = Modifier
                .align(Alignment.Center)
                .size(iconSize),
            tint = Color.Unspecified
        )
    }
}