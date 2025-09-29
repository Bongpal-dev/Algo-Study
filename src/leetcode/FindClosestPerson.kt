package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (x1, y1, z1) = listOf(2, 7, 4)
    val (x2, y2, z2) = listOf(2, 5, 6)
    val (x3, y3, z3) = listOf(1, 5, 3)

    println(findClosest(x1, y1, z1))
    println(findClosest(x2, y2, z2))
    println(findClosest(x3, y3, z3))
}

private fun findClosest(x: Int, y: Int, z: Int): Int {
    val p1 = (x - z).absoluteValue
    val p2 = (y - z).absoluteValue

    return when {
        p1 == p2 -> 0
        p1 < p2 -> 1
        else -> 2
    }
}

// https://leetcode.com/problems/find-closest-person/description/