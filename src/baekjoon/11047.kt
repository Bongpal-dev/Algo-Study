package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "10 4200\n1\n5\n10\n50\n100\n500\n1000\n5000\n10000\n50000",
        "10 4790\n1\n5\n10\n50\n100\n500\n1000\n5000\n10000\n50000"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    var (n, k) = readLine().split(" ").map { it.toInt() }
    val prices = List(n) { readLine().toInt() }
    var m = prices.indexOfLast { it <= k }
    var count = 0

    while (k > 0) {
        if (k >= prices[m]) {
            k -= prices[m]
            count++
        } else {
            m--
        }
    }

    println(count)
}

// https://www.acmicpc.net/problem/11047