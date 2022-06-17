package com.chaudharynabin6.compose_svg

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Icon() {

    //draw shapes here
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)
        Canvas(
            modifier = Modifier
                .size(400.dp)
                .padding(16.dp)
        ) {
            drawRoundRect(
                brush = Brush.linearGradient(colors = instaColors),
                cornerRadius = CornerRadius(60f, 60f),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
            drawCircle(
                brush = Brush.linearGradient(colors = instaColors),
                radius = 45f,
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
            drawCircle(
                brush = Brush.linearGradient(colors = instaColors),
                radius = 13f,
                center = Offset(this.size.width * .80f, this.size.height * 0.20f),
            )
        }
    }
}
