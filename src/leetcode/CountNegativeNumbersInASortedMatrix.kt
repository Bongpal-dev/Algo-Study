package leetcode

fun main() {
    val grid1 = arrayOf(
        intArrayOf(4, 3, 2, -1),
        intArrayOf(3, 2, 1, -1),
        intArrayOf(1, 1, -1, -2),
        intArrayOf(-1, -1, -2, -3),
    )
    val grid2 = arrayOf(
        intArrayOf(3, 2),
        intArrayOf(1, 0),
    )

    println(countNegatives(grid1))
    println(countNegatives(grid2))
}

private fun countNegatives(grid: Array<IntArray>) = grid.sumOf { r -> r.count { it < 0 } }

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

