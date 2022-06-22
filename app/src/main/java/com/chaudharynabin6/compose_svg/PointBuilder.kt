package com.chaudharynabin6.compose_svg

class PointBuilder(
    private val width: Float,
    private val height: Float,
    private val maxX: Float,
    private val maxY: Float,
) {
    fun toScale(point: Point): Point {

        return Point(
            x = point.x / maxX * width,
            y = (1 - point.y / maxY) * height
        )
    }
}
