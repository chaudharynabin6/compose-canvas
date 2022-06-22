package com.chaudharynabin6.compose_svg

import kotlin.math.*

class SmoothLine(
    private var points: List<Point>,
    private var smoothing: Float = .2f,
) {
    data class ControlProperties(val length: Float, val angle: Float)
    data class BezierPoints(val c1: Point, val c2: Point, val next: Point)

    private fun line(pointA: Point, pointB: Point): ControlProperties {
        val lengthX = pointB.x - pointA.x
        val lengthY = pointB.y - pointA.y

        return ControlProperties(
            length = sqrt(lengthX.pow(2) + lengthY.pow(2)),
            angle = atan2(lengthY, lengthX)
        )
    }

    private fun controlPoint(current: Point, previous: Point?, next: Point?, reverse: Boolean): Point {

        // When 'current' is the first or last point of the array
        // 'previous' or 'next' don't exist.
        // Replace with 'current'
        val p = previous ?: current
        val n = next ?: current

        // Properties of the opposed-line
        val o = line(p, n)

        // If is end-control-point, add PI to the angle to go backward

        val aPlus = if (reverse) {
            PI.toFloat()
        } else {
            0f
        }
        val angle = o.angle + aPlus
        val length = o.length * smoothing

        // The control point position is relative to the current point
        val x = current.x + cos(angle) * length
        val y = current.y + sin(angle) * length
        return Point(x, y)
    }

    private fun bezierCommand(point: Point, i: Int, a: List<Point>): BezierPoints {
        // start control point
        val c1 = controlPoint(
            a[i - 1],
            try {
                a[i - 2]
            } catch (e: IndexOutOfBoundsException) {
                null
            }, point, false)
        // end control point
        val c2 = controlPoint(point, a[i - 1], try {
            a[i + 1]
        } catch (e: IndexOutOfBoundsException) {
            null
        }, true)

        return BezierPoints(
            c1 = c1,
            c2 = c2,
            next = point
        )

    }

    fun getBezierPoints(): MutableList<BezierPoints> {
        val listOfBezierPoints = mutableListOf<BezierPoints>()
        for (i in 1 until points.size) {
            val bezierPoints = bezierCommand(point = points[i], i = i, a = points)
            listOfBezierPoints.add(bezierPoints)
        }
        return listOfBezierPoints
    }

}