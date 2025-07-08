package com.example.caffeine.composable

import android.graphics.Paint
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb


fun Modifier.customShadow(
    shadowColor: Color = Color.Black.copy(alpha = 0.12f),
    shadowRadius: Float = 75f,
    offsetX: Float = 0f,
    offsetY: Float = 4f,
    cornerRadius: Float = 100f
): Modifier = this.drawWithCache {
    onDrawWithContent {
        drawIntoCanvas { canvas ->
            canvas.nativeCanvas.drawRoundRect(
                0f, 0f, size.width, size.height, cornerRadius, cornerRadius, Paint().apply {
                    color = android.graphics.Color.TRANSPARENT
                    setShadowLayer(
                        shadowRadius, offsetX, offsetY, shadowColor.toArgb()
                    )
                }
            )
        }
        drawContent()
    }
}