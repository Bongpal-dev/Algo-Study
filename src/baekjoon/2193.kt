package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "1",
        "2",
        "3",
        "4",
        "90"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    if (n < 3) {
        println("1")
        return@with
    }

    val dp = LongArray(n + 1)

    dp[1] = 1
    dp[2] = 1

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[n])
}

// https://www.acmicpc.net/problem/2193