package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "4 2\n1 2 100 101",
        "4 3\n1 2 3 4",
        "3 1\n3 2 1",
        "7 2\n1 2 3 6 7 8 9"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val damaged = readLine().split(" ").map { it.toInt() }.sorted()
    var count = 0
    var cover = 0

    for (s in damaged) {
        if (s > cover) {
            count++
            cover = s + l - 1
        }
    }
    println(count)
}

// https://www.acmicpc.net/problem/1449