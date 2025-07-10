package leetcode

fun main() {
    val (matrix1, target1) = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60),
    ) to 3
    val (matrix2, target2) = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60),
    ) to 13
    val (matrix3, target3) = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60),
    ) to 5
    val (matrix4, target4) = arrayOf(
        intArrayOf(1),
    ) to 1


    println(searchMatrix(matrix1, target1))
    println(searchMatrix(matrix2, target2))
    println(searchMatrix(matrix3, target3))
    println(searchMatrix(matrix4, target4))
}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var y = 0
    var x = matrix[0].size - 1

    while (y < matrix.size && x >= 0) {
        when {
            matrix[y][x] == target -> return true
            matrix[y][x] > target -> x--
            matrix[y][x] < target -> y++
        }
    }
    return false
}

// https://leetcode.com/problems/search-a-2d-matrix/description/