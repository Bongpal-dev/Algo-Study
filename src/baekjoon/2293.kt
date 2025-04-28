import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3 10\n1\n2\n5",
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
    val coins = List(n) { readLine().toInt() }
    val dp = IntArray(k + 1)

    dp[0] = 1

    for (coin in coins) {
        for (i in coin..k) {
            dp[i] += dp[i - coin]
        }
    }
    println(dp[k])
}

// https://www.acmicpc.net/problem/2293