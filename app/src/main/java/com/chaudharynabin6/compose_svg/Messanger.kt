package com.chaudharynabin6.compose_svg

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MessengerIcon() {

    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Canvas(
            modifier = Modifier
                .size(400.dp)
                .padding(16.dp)
                .border(5.dp, color = Color.Red)
        ) {

            val trianglePath = Path(

            ).let {
                it.moveTo(this.size.width * .20f, this.size.height * .77f)
                it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
                it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
                it.addRect(
                    rect = Rect(
                        0f,0f,this.size.width*.2f,this.size.height*.2f
                    )
                )
                it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
                it.close()

                it
            }

//            val electricPath = Path().let {
//                it.moveTo(this.size.width * .20f, this.size.height * 0.60f)
//                it.lineTo(this.size.width * .45f, this.size.height * 0.35f)
//                it.lineTo(this.size.width * 0.56f, this.size.height * 0.46f)
//                it.lineTo(this.size.width * 0.78f, this.size.height * 0.35f)
//                it.lineTo(this.size.width * 0.54f, this.size.height * 0.60f)
//                it.lineTo(this.size.width * 0.43f, this.size.height * 0.45f)
//                it.close()
//                it
//            }

//            drawOval(
//                Brush.verticalGradient(colors = colors),
//                size = Size(this.size.width, this.size.height * 0.95f)
//            )

            drawPath(
                path = trianglePath,
                Brush.verticalGradient(colors = colors),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )

//            drawPath(path = electricPath, color = Color.White)

        }
    }
}