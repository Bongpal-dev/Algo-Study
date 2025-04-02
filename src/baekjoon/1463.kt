package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "2", "10"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val x = readLine().toInt()
    val dp = IntArray(x + 1) { 0 }

    for (n in 2..x) {
        dp[n] = dp[n - 1] + 1

        if (n % 2 == 0) dp[n] = minOf(dp[n], dp[n / 2] + 1)
        if (n % 3 == 0) dp[n] = minOf(dp[n], dp[n / 3] + 1)
    }

    println(dp[x])
}