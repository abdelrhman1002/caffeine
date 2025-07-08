package com.example.caffeine.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.SnigletFontFamily
import com.example.caffeine.ui.theme.secondaryColor

@Composable
fun TextWithVerticalDots(text: String , withDot: Boolean = true) {
    Text(
        text,
        fontFamily = SnigletFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight(700),
        color = secondaryColor,
        letterSpacing = (0.25f).sp,
    )
    if(withDot)
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.dot),
            contentDescription = "dot",
            tint = Color.Unspecified,
        )
        Icon(
            painter = painterResource(id = R.drawable.dot),
            contentDescription = "dot",
            tint = Color.Unspecified,
        )
    }
}