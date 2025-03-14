package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "10 2\n3 -2 -4 -9 0 3 7 13 8 -3",
        "10 5\n3 -2 -4 -9 0 3 7 13 8 -3",
        "2 2\n-100 -100",
        "5 3\n-1 -2 -3 -4 -5",
        "4 4\n10 20 30 40"
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
    val t = readLine().split(" ").map { it.toInt() }
    var sum = t.take(k).sum()
    var max = sum

    for (i in k..<n) {
        sum += t[i]
        sum -= t[i-k]
        max = maxOf(sum, max)
    }

    println(max)
}

// https://www.acmicpc.net/problem/2559