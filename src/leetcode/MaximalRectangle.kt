package leetcode

fun main() {
    val matrix1 = arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0'),
    )
    val matrix2 = arrayOf(
        charArrayOf('0')
    )
    val matrix3 = arrayOf(
        charArrayOf('1')
    )

    println(maximalRectangle(matrix1))
    println(maximalRectangle(matrix2))
    println(maximalRectangle(matrix3))
}

private fun maximalRectangle(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0

    val dp = Array(matrix.size) { IntArray(matrix[0].size) }
    var answer = 0

    for (y in matrix.indices) {
        for (x in matrix[0].indices) {
            dp[y][x] = if (matrix[y][x] == '1') {
                if (y > 0) dp[y - 1][x] + 1 else 1
            } else {
                0
            }
        }
        answer = maxOf(answer, largestRectangleArea(dp[y]))
    }

    return answer
}

private fun largestRectangleArea(heights: IntArray): Int {
    val stack = arrayListOf<Int>()
    var max = 0
    val nHeights = heights + 0

    for (i in nHeights.indices) {
        while (stack.isNotEmpty() && nHeights[i] < nHeights[stack.last()]) {
            val h = nHeights[stack.removeLast()]
            val prev = if (stack.isEmpty()) -1 else stack.last()
            val w = i - prev - 1

            max = maxOf(max, h * w)
        }
        stack.add(i)
    }

    return max
}

// https://leetcode.com/problems/maximal-rectangle/description/