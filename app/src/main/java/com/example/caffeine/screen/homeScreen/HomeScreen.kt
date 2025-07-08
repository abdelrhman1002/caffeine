package com.example.caffeine.screen.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.caffeine.R
import com.example.caffeine.composable.CoffeeSelectionPager
import com.example.caffeine.composable.MyCoffeeButton
import com.example.caffeine.composable.TopAppBar
import com.example.caffeine.data.DrinkItem
import com.example.caffeine.ui.theme.primaryColor
import com.example.caffeine.ui.theme.urbanistFontFamily

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(), onClickContinue: (String) -> Unit = {}
) {
    val drinks by viewModel.drinks.collectAsState()
    val selectedIndex by viewModel.selectedDrinkIndex.collectAsState()

    val pagerState = rememberPagerState(
        pageCount = { drinks.size }, initialPage = selectedIndex
    )

    HomeScreenContent(
        drinks = drinks,
        pagerState = pagerState,
        onClickContinue = { selectedDrink ->
            onClickContinue(selectedDrink)
        },
    )
}

@Composable
fun HomeScreenContent(
    drinks: List<DrinkItem>,
    pagerState: PagerState,
    onClickContinue: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(modifier = Modifier.fillMaxWidth())
            Text(
                text = "Good Morning",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 16.dp),
                color = Color(0xffB3B3B3),
                fontSize = 36.sp,
                fontWeight = FontWeight(700),
                fontFamily = urbanistFontFamily,
                letterSpacing = 0.25.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Abdelrhman",
                    color = Color(0xff3B3B3B),
                    fontSize = 36.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = urbanistFontFamily,
                    letterSpacing = 0.25.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.sun),
                    contentDescription = "Sun icon",
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
            Text(
                text = "What would you like to drink today?",
                color = primaryColor.copy(alpha = 0.8f),
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                fontFamily = urbanistFontFamily,
                letterSpacing = 0.25.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 4.dp)
            )
        }

        CoffeeSelectionPager(
            drinkList = drinks, pagerState = pagerState
        )

        Spacer(modifier = Modifier.weight(1f))
        MyCoffeeButton(
            text = "Continue",
            icon = R.drawable.arrow_right_04,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                onClickContinue(
                    drinks[pagerState.currentPage].title
                )
            })
    }
}