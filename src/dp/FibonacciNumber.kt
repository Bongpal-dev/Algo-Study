package dp

fun main() {
    val n1 = 2
    val n2 = 3
    val n3 = 4
    val n4 = 10

    println(fib(n1))
    println(fib(n2))
    println(fib(n3))
    println(fib(n4))
}

private fun fib(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1

    val dp = IntArray(n + 1)

    dp[0] = 0
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}

// https://leetcode.com/problems/fibonacci-number/description/