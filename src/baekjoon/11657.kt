package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3 4\n1 2 4\n1 3 3\n2 3 -1\n3 1 -2",
        "3 4\n1 2 4\n1 3 3\n2 3 -4\n3 1 -2",
        "3 2\n1 2 4\n1 2 3"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val routes = List(m) { readLine().split(" ").map { it.toInt() }.let { (a, b, c) -> Route(a, b, c) } }
    val durations = MutableList(n + 1) { Long.MAX_VALUE }

    durations[1] = 0

    for (i in 1 until n) {
        for ((s, d, t) in routes) {
            if (durations[s] != Long.MAX_VALUE && durations[d] > durations[s] + t) {
                durations[d] = durations[s] + t
            }
        }
    }

    for ((from, to, time) in routes) {
        if (durations[from] != Long.MAX_VALUE && durations[from] + time < durations[to]) {
            println(-1)
            return@with
        }
    }

    durations.mapIndexedNotNull { i, v ->
        if (i < 2) {
            null
        } else {
            if (durations[i] == Long.MAX_VALUE) "-1" else v.toString()
        }
    }.joinToString("\n").run(::println)
}

private data class Route(
    val start: Int,
    val destination: Int,
    val time: Int
)

// https://www.acmicpc.net/problem/11657