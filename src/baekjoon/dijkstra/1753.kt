package baekjoon.dijkstra

import java.io.ByteArrayInputStream
import java.util.PriorityQueue

fun main() {
    val inputs = listOf(
        "5 6\n1\n5 1 1\n1 2 2\n1 3 3\n2 3 4\n2 4 5\n3 4 6"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (v, e) = readLine().split(" ").map { it.toInt() }
    val k = readLine().toInt()
    val times = IntArray(v) { Int.MAX_VALUE }
    val graph = hashMapOf<Int, MutableList<Pair<Int, Int>>>()
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    repeat(e) {
        val (u, v, w) = readLine().split(" ").map { it.toInt() }

        graph.getOrPut(u) { mutableListOf() }.add(Pair(v, w))
    }
    pq.add(Pair(k, 0))

    while (pq.isNotEmpty()) {
        val current = pq.poll()

        if (times[current.first - 1] < current.second) continue

        times[current.first - 1] = current.second

        for (n in graph[current.first] ?: emptyList()) {
            val new = current.second + n.second

            if (times[n.first - 1] > new) {
                pq.add(Pair(n.first, current.second + n.second))
            }
        }
    }

    times.forEach {
        println(if (it == Int.MAX_VALUE) "INF" else it)
    }
}

// https://www.acmicpc.net/problem/1753