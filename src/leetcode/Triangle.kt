package leetcode

fun main() {
    val triangle1 = listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3))
    val triangle2 = listOf(listOf(-10))

    println(minimumTotal(triangle1))
    println(minimumTotal(triangle2))
}

private fun minimumTotal(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val dp = IntArray(n) { triangle[n - 1][it] }

    for (i in n - 2 downTo 0) {
        for (j in 0..i) {
            dp[j] = triangle[i][j] + minOf(dp[j], dp[j + 1])
        }
    }

    return dp[0]
}

// https://leetcode.com/problems/triangle/description/