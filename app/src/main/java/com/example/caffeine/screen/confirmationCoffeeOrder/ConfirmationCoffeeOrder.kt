package com.example.caffeine.screen.confirmationCoffeeOrder

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caffeine.R
import com.example.caffeine.composable.MyCoffeeButton
import com.example.caffeine.composable.TopBarAppIcon
import com.example.caffeine.ui.theme.SnigletFontFamily
import com.example.caffeine.ui.theme.urbanistFontFamily

@Composable
fun ConfirmationCoffeeOrder(
    onNavigateToBack: () -> Unit,
    onNavigateToHome: () -> Unit,
    image: Int,
    viewModel: ConfirmationCoffeeOrderViewModel = viewModel()
) {
    val animateImage = viewModel.animateImage.value

    ConfirmationCoffeeOrderContent(
        onNavigateToBack, onNavigateToHome, image, animateImage
    )
}

@Composable
fun ConfirmationCoffeeOrderContent(
    onNavigateToBack: () -> Unit, onNavigateToHome: () -> Unit, image: Int, animateImage: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBarAppIcon(
            appIcon = R.drawable.cancel_01,
            onClick = onNavigateToBack,
            modifier = Modifier.align(Alignment.Start)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.coffee_beans),
                contentDescription = null,
                tint = Color(0xFF7C351B)
            )

            Text(
                text = "More Espresso, Less Depresso", style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF7C351B),
                    letterSpacing = 0.25.sp,
                    fontFamily = SnigletFontFamily,
                ), modifier = Modifier.align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.coffee_beans),
                contentDescription = null,
                tint = Color(0xFF7C351B)
            )
        }

        AnimatedVisibility(
            visible = animateImage,
            enter = fadeIn(tween(500)) + scaleIn(tween(750)),
            exit = fadeOut(tween(500)) + scaleOut(tween(750))
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .defaultMinSize(minHeight = 310.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
        Row(
            modifier = Modifier.padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Bon appétit", style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xCC1F1F1F),
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanistFontFamily,
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.magic_wand_01),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        Spacer(Modifier.weight(1f))

        MyCoffeeButton(
            "Thank youuu",
            icon = R.drawable.arrow_right_04,
            onClick = onNavigateToHome,
        )
    }
}