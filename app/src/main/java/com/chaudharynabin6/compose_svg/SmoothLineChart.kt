package com.chaudharynabin6.compose_svg


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
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
@Preview(showBackground = true, showSystemUi = true)
fun SmoothLineChart() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .border(
                5.dp,
                color = Color.Gray
            )

    ) {

        Canvas(modifier = Modifier
            .width(400.dp)
            .height(400.dp)
            .border(
                5.dp,
                color = Color.Red
            )) {

            val width = this.size.width
            val height = this.size.height

            val pointBuilder = PointBuilder(width = width, height = height, maxX = 10f, maxY = 10f)


            val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))

            val points = listOf<Point>(
                Point(1f, 2f),
                Point(2f, 2f),
                Point(3f, 4f),
                Point(5f, 6f),
                Point(6f, 1f),
                Point(7f, 2f),
            )

            val scaledPoints = points.map { point -> pointBuilder.toScale(point) }
            val bezierPoints = SmoothLine(points = scaledPoints).getBezierPoints()

            val bezierCurve = Path().apply {
                moveTo(scaledPoints[0].x, scaledPoints[0].y)
                bezierPoints.forEach {
                    bezierPoints ->
                    val c1 = bezierPoints.c1
                    val c2 = bezierPoints.c2
                    val next = bezierPoints.next

                    cubicTo(
                        x1 = c1.x,
                        y1 = c1.y,
                        x2 = c2.x,
                        y2 = c2.y,
                        x3 = next.x,
                        y3 = next.y
                    )
                }
            }
            val line = Path().apply {
                moveTo(scaledPoints[0].x,scaledPoints[0].y)

                for (i in 1 until scaledPoints.size){
                    val point = scaledPoints[i]
                    lineTo(
                        x = point.x,
                        y = point.y
                    )
                }

            }

            drawPath(
                path = bezierCurve,
                Brush.verticalGradient(colors = colors),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
            drawPath(
                path = line,
                Brush.verticalGradient(
                    listOf(
                        Color.Gray,
                        Color.Black
                    )
                ),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
        }
    }
}