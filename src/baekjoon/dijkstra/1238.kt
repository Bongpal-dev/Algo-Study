package baekjoon.dijkstra

import java.io.ByteArrayInputStream
import java.util.PriorityQueue

fun main() {
    val inputs = listOf(
        "4 8 2\n1 2 4\n1 3 2\n1 4 7\n2 1 1\n2 3 5\n3 1 2\n3 4 4\n4 2 3"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, m, x) = readLine().split(" ").map { it.toInt() }
    val graph = hashMapOf<Int, MutableList<Path>>()

    repeat(m) {
        val (s, e, t) = readLine().split(" ").map { it.toInt() }

        graph.getOrPut(s) { mutableListOf() }.add(Path(e, t))
    }

    val ds = mutableListOf<IntArray>()

    for (i in 1..n) {
        ds += find(n, i, x, graph)
    }

    println(ds.mapIndexed{ i, v -> v[x-1] + ds[x-1][i] }.max())
}

private fun find(n: Int, s: Int, e: Int, graph: HashMap<Int, MutableList<Path>>): IntArray {
    val duration = IntArray(n) { Int.MAX_VALUE }
    val pq = PriorityQueue<Path>(compareBy { it.duration })

    duration[s - 1] = 0
    pq.add(Path(s, 0))

    while (pq.isNotEmpty()) {
        val current = pq.poll()

        if (current.destination == e && current.duration != 0) break

        if (duration[current.destination - 1] < current.duration) continue

        for (d in graph[current.destination] ?: emptyList()) {
            val newDuration = current.duration + d.duration

            if (duration[d.destination - 1] > newDuration) {
                duration[d.destination - 1] = newDuration
                pq.add(Path(d.destination, newDuration))
            }
        }
    }

    return duration
}

private data class Path(
    val destination: Int,
    val duration: Int,
)

// https://www.acmicpc.net/problem/1238