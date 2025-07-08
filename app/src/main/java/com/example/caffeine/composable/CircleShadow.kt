package com.example.caffeine.composable

import android.graphics.Paint
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb

internal fun Modifier.circleShadow(
    alpha: Float,
    isSelected: Boolean = true,
    shadowColor: Color = Color(0x80894B23),
    shadowRadius: Float = 24f,
    offsetX: Float = 0f,
    offsetY: Float = 12f,
    circleSizeRatio: Float = 1.7f
): Modifier = this.drawWithCache {
    onDrawWithContent {
        if (isSelected && alpha > 0f) {
            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.drawCircle(
                    size.width / 2,
                    size.height / 2,
                    size.minDimension / circleSizeRatio,
                    Paint().apply {
                        color = android.graphics.Color.TRANSPARENT
                        setShadowLayer(
                            shadowRadius, offsetX, offsetY, shadowColor.toArgb()
                        )
                    }
                )
            }
        }
        drawContent()
    }
}