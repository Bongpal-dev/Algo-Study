package leetcode

fun main() {
    val grid1 = arrayOf(
        intArrayOf(9, 9, 8, 1),
        intArrayOf(5, 6, 2, 6),
        intArrayOf(8, 2, 6, 4),
        intArrayOf(6, 2, 2, 2),
    )
    val grid2 = arrayOf(
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 2, 1, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1),
    )

    println(largestLocal(grid1).joinToString("\n") { it.joinToString() })
    println(largestLocal(grid2).joinToString("\n") { it.joinToString() })
}

private fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    return Array(grid.size - 2) { y ->
        IntArray(grid.size - 2) { x ->
            grid.findMax(x, y)
        }
    }
}

private fun Array<IntArray>.findMax(x: Int, y: Int): Int {
    var result = 0

    for (i in y..y + 2) {
        for (j in x..x + 2) {
            result = maxOf(result, this[i][j])
        }
    }

    return result
}

// https://leetcode.com/problems/largest-local-values-in-a-matrix/description/