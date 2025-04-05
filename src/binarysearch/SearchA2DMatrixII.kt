package binarysearch

fun main() {
    val (matrix1, target1) = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(3, 6, 9, 16, 22),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30),
    ) to 5
    val (matrix2, target2) = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(3, 6, 9, 16, 22),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30),
    ) to 20
    val (matrix3, target3) = arrayOf(intArrayOf(-1, 3)) to 3
    val (matrix4, target4) = arrayOf(intArrayOf(-5)) to -2
    val (matrix5, target5) = arrayOf(intArrayOf(1, 4), intArrayOf(2, 5)) to 2

    println(searchMatrix(matrix1, target1))
    println(searchMatrix(matrix2, target2))
    println(searchMatrix(matrix3, target3))
    println(searchMatrix(matrix4, target4))
    println(searchMatrix(matrix5, target5))
}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var (x, y) = matrix[0].lastIndex to 0

    while (x > -1 && y < matrix.size) {
        when {
            matrix[y][x] == target -> return true
            matrix[y][x] < target -> y++
            matrix[y][x] > target -> x--
        }
    }
    return false
}

// https://leetcode.com/problems/search-a-2d-matrix-ii/description/