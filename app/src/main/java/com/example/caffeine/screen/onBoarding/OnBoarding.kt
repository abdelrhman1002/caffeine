package com.example.caffeine.screen.onBoarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.composable.AnimatedGhost
import com.example.caffeine.composable.AnimatedStar
import com.example.caffeine.composable.MyCoffeeButton
import com.example.caffeine.composable.TopAppBar
import com.example.caffeine.ui.theme.SnigletFontFamily

@Composable
fun OnBoardingScreen(
    onNavigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                AnimatedStar(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(bottom = 50.dp)
                )

                Text(
                    "Hocus\n" + "Pocus\n" + "I Need Coffee\n" + "to Focus",
                    fontFamily = SnigletFontFamily,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 50.sp,
                    fontWeight = FontWeight(400),
                    letterSpacing = 0.25.sp,
                )
                AnimatedStar(
                    modifier = Modifier.align(Alignment.TopEnd)
                )
            }
            AnimatedStar(
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
        AnimatedGhost()
        Spacer(modifier = Modifier.weight(1f))
        MyCoffeeButton(
            text = "bring my coffee",
            icon = R.drawable.coffee_02,
            onClick = onNavigateToHome,
        )
    }
}

@Preview
@Composable
private fun OnBoardingScreenPreview() {
    OnBoardingScreen(onNavigateToHome = {})
}