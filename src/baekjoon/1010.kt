package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3\n2 2\n1 5\n13 29"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

// DP 풀이
private fun solve() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val dp = Array(m + 1) { IntArray(m + 1) }

        for (i in 1..m) dp[1][i] = i

        // y = n, x = m
        for (y in 2..m) {
            for (x in 2..m) {
                if (y > x) continue
                dp[y][x] = if (y == x) 1 else dp[y - 1][x - 1] + dp[y][x - 1]

            }
        }
        println(dp[n][m])
    }
}

/* 팩토리얼 계산 풀이
private fun solve() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val fact = (1..m + 1).runningFold(1.toBigInteger()) { acc, v -> acc * v.toBigInteger() }

        print(fact[m] / (fact[n] * fact[m - n]))
    }
}
 */

// https://www.acmicpc.net/problem/1010