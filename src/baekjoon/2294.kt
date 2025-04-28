package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3 15\n1\n5\n12",
        "3 15\n6\n7\n12",
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val coins = List(n) { readLine().toInt() }.sorted()
    val dp = IntArray(k + 1) { 10001 }

    dp[0] = 0

    for (coin in coins) {
        for (i in coin..k) {
            dp[i] = minOf(dp[i - coin] + 1, dp[i])
        }
    }
    println(if (dp[k] > 10000) -1 else dp[k])
}

// https://www.acmicpc.net/problem/2294