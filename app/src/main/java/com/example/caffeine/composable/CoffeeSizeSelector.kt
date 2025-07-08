package com.example.caffeine.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.caffeine.screen.customizationCoffee.CupSize

@Composable
fun CoffeeSizeSelector(
    modifier: Modifier = Modifier,
    sizes: List<CupSize> = CupSize.entries,
    onSizeSelected: (CupSize) -> Unit = {}
) {
    var selectedSize by remember { mutableStateOf(CupSize.M) }

    Row(
        modifier = modifier
            .background(color = Color(0xFFF5F5F5), shape = CircleShape)
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        sizes.forEach { size ->
            CoffeeSizeTextItem(
                text = size.name, isSelected = size == selectedSize, onClick = {
                    selectedSize = size
                    onSizeSelected(size)
                }
            )
        }
    }
}