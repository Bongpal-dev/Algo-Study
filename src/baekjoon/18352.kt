package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "4 4 2 1\n1 2\n1 3\n2 3\n2 4",
        "4 3 2 1\n1 2\n1 3\n1 4",
        "4 4 1 1\n1 2\n1 3\n2 3\n2 4",
        "4 3 1 1\n2 3\n3 4\n4 2\n",
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<Int>()
    val (n, m, k, x) = readLine().split(" ").map { it.toInt() }
    val graph = hashMapOf<Int, MutableList<Int>>()
    val durations = IntArray(n + 1) { -1 }
    val queue = ArrayDeque<Int>()

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        graph.getOrPut(a) { mutableListOf() }.add(b)
    }

    queue.add(x)
    durations[x] = 0

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        for (n in graph[current] ?: emptyList()) {
            if (durations[n] == -1) {
                durations[n] = durations[current] + 1
                queue.add(n)
            }
        }
    }

    durations.forEachIndexed { i, d -> if (d == k) answer += i }
    println(if (answer.isEmpty()) -1 else answer.joinToString("\n"))
}

// https://www.acmicpc.net/problem/18352