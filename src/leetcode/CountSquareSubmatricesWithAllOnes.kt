package leetcode

fun main() {
    val matrix1 = arrayOf(
        intArrayOf(0, 1, 1, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(0, 1, 1, 1)
    )
    val matrix2 = arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0)
    )

    println(countSquares(matrix1))
    println(countSquares(matrix2))
}

private fun countSquares(matrix: Array<IntArray>): Int {
    var answer = 0
    val dp = Array(matrix.size) { IntArray(matrix[0].size) }

    for (y in matrix.indices) {
        for (x in matrix[0].indices) {
            if (matrix[y][x] == 1) {
                dp[y][x] = if (y == 0 || x == 0) {
                    1
                } else {
                    1 + minOf(dp[y - 1][x], dp[y][x - 1], dp[y - 1][x - 1])
                }

                answer += dp[y][x]
            }
        }
    }

    return answer
}

// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description