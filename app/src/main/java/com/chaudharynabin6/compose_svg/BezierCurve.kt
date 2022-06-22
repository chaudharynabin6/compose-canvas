package com.chaudharynabin6.compose_svg

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BezierCurve() {
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

            var p1 = Point(0f, 0f)
            var p2 = Point(10f, 10f)
            var c1 = Point(10f, 0f)
            var c2 = Point(0f, 10f)

            pointBuilder.apply {
                p1 = toScale(p1)
                p2 = toScale(p2)
                c1 = toScale(c1)
                c2 = toScale(c2)
            }

            val bezierCurve = Path().apply {
                moveTo(p1.x, p1.y)
                cubicTo(
                    x1 = c1.x,
                    y1 = c1.y,
                    x2 = c2.x,
                    y2 = c2.y,
                    x3 = p2.x,
                    y3 = p2.y
                )
            }
            listOf(
                p1, p2, c1, c2
            ).forEach {
                drawCircle(
                    color = Color.Red,
                    radius = 10f,
                    center = Offset(

                        it.x,
                        it.y
                    )
                )
            }





            drawPath(
                path = bezierCurve,
                Brush.verticalGradient(colors = colors),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
        }
    }
}