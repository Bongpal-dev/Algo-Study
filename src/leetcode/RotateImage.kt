package leetcode

fun main() {
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    val matrix2 = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16),
    )

    rotate(matrix1)
    rotate(matrix2)

    println(matrix1.joinToString("\n") { it.joinToString(prefix = "[", postfix = "]") { it.toString().padEnd(2) } })
    println(matrix2.joinToString("\n") { it.joinToString(prefix = "[", postfix = "]") { it.toString().padEnd(2) } })
}

private fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size

    for (y in 0..<n) {
        for (x in y + 1..<n) {
            matrix[x][y] = matrix[y][x].also { matrix[y][x] = matrix[x][y] }
        }
    }

    for (y in matrix.indices) {
        val colSize = matrix[y].size

        for (x in 0..(colSize - 1) / 2) {
            matrix[y][x] = matrix[y][colSize - 1 - x].also { matrix[y][colSize - 1 - x] = matrix[y][x] }
        }
    }
}

// https://leetcode.com/problems/rotate-image/description/