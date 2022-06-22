package com.chaudharynabin6.compose_svg

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Graph() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Canvas(modifier = Modifier
            .width(400.dp)
            .height(200.dp)) {
            val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
            val width = this.size.width
            val height = this.size.height
            val maxX = 10f
            val maxY = 10f
            val listOfPoint = listOf<Point>(
                Point(1f, 2f),
                Point(2f, 3f),
                Point(3f, 1f),
                Point(4f, 10f),
                Point(5f, 1f)
            )

            val scalePointPosition = listOfPoint.map {
                Point(
                    it.x / maxX,
                    it.y / maxY
                )
            }

            val listOfLinesToDraw = Path().let {
                it.moveTo(
                    scalePointPosition[0].x * width,
                    height - scalePointPosition[0].y * height
                )
                for (i in 1 until scalePointPosition.size) {
                    it.lineTo(scalePointPosition[i].x * width, height - scalePointPosition[i].y * height)
                }

                it
            }



            val listOfVerticalDash = mutableListOf<Path>()
            for (i in 9 downTo 0) {
                listOfVerticalDash.add(
                    Path().let {
                        it.moveTo(
                            -20f,
                            i * (height.toFloat() / 10)
                        )
                        it.lineTo(
                            20f,
                            i * (height / 10)
                        )
                        it
                    }
                )
            }

            val listOfHorizontalDash = mutableListOf<Path>()
            for (i in 1..10) {
                listOfVerticalDash.add(
                    Path().let {
                        it.moveTo(
                            i * (width / 10),
                            height + 20
                        )
                        it.lineTo(
                            i * (width / 10),
                            height - 20
                        )
                        it
                    }
                )
            }
            val leftHalfRect = Path().let {
                it.lineTo(
                    0f,
                    height
                )
                it.lineTo(
                    width,
                    height
                )
                it
            }

            drawPath(
                path = leftHalfRect,
                Brush.verticalGradient(colors = colors),
                style = Stroke(width = 10f, cap = StrokeCap.Round)
            )

            drawPath(
                path = listOfLinesToDraw,
                Brush.verticalGradient(colors = colors),
                style = Stroke(width = 10f, cap = StrokeCap.Round)
            )

            listOfVerticalDash.forEach {
                drawPath(
                    path = it,
                    Brush.verticalGradient(colors = colors),
                    style = Stroke(width = 5f, cap = StrokeCap.Round)
                )
            }
            listOfHorizontalDash.forEach {
                drawPath(
                    path = it,
                    Brush.verticalGradient(colors = colors),
                    style = Stroke(width = 5f, cap = StrokeCap.Round)
                )
            }
        }
    }
}