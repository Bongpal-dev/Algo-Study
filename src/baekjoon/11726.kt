package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf("2", "9", "1000")

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1) { 1 }

    for (i in 2..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }

    println(dp[n])
}