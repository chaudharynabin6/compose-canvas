package com.chaudharynabin6.compose_svg


data class Point(
    val x: Float,
    val y: Float,
)

fun PointObject.toPoint() : Point{

    return Point(
        x = this.x.toFloat(),
        y = this.y.toFloat()
    )
}