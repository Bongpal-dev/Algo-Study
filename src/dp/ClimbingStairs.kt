package dp

fun main() {
    val n1 = 2
    val n2 = 3

    println(climbStairs(n1))
    println(climbStairs(n2))
}

fun climbStairs(n: Int): Int {
    if (n == 1) return 1

    val dp = IntArray(n + 1)

    dp[0] = 1
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}

// https://leetcode.com/problems/climbing-stairs/description/