package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "7\n3 10\n5 20\n1 10\n1 20\n2 15\n4 40\n2 200",
        "10\n1 1\n1 2\n1 3\n1 4\n1 5\n1 6\n1 7\n1 8\n1 9\n1 10",
        "10\n5 10\n5 9\n5 8\n5 7\n5 6\n5 10\n5 9\n5 8\n5 7\n5 6",
        "10\n5 50\n4 40\n3 30\n2 20\n1 10\n1 10\n2 20\n3 30\n4 40\n5 50"
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
    val reservations = List(n) {
        readLine().split(" ").map { it.toInt() }.let { (t, p) -> Reserve(t, p) }
    }
    val dp = IntArray(n + 1)

    for (i in reservations.indices) {
        val (t, p) = reservations[i]

        dp[i + 1] = maxOf(dp[i + 1], dp[i])

        if (i + t <= n) dp[i + t] = maxOf(dp[i + t], dp[i] + p)
    }

    println(dp.max())
}


data class Reserve(
    val time: Int,
    val pay: Int
)

// https://www.acmicpc.net/problem/14501