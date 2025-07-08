package com.example.caffeine.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.primaryColor
import com.example.caffeine.ui.theme.urbanistFontFamily

@Composable
fun CoffeeItem(
    name: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = name,
            color = primaryColor,
            fontSize = 32.sp,
            fontWeight = FontWeight(700),
            fontFamily = urbanistFontFamily,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}