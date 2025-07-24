package leetcode

fun main() {
    val n1 = 3
    val n2 = 1
    val n3 = 4

    println(numTrees(n1))
    println(numTrees(n2))
    println(numTrees(n3))
}

private fun numTrees(n: Int): Int {
    val dp = IntArray(n + 1)

    dp[0] = 1
    dp[1] = 1

    for (i in 2..n) {
        val pi = i - 1
        var current = 0

        for (j in 0..pi) {
            current += dp[j] * dp[pi - j]
        }
        dp[i] = current
    }

    return dp[n]
}

// https://leetcode.com/problems/unique-binary-search-trees/description/