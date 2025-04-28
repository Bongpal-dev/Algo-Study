package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "4\n2 3 1\n5 2 4 1",
        "4\n3 3 4\n1 1 1 1"
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
    val d = readLine().split(" ").map { it.toLong() }
    val c = readLine().split(" ").map { it.toLong() }

    var result = 0L
    var minPrice = c.first()

    for (i in 1 .. c.lastIndex) {
        result += d[i-1] * minPrice

        if (c[i] < minPrice) minPrice = c[i]
    }

    println(result)
}

// https://www.acmicpc.net/problem/13305