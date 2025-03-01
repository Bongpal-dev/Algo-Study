package baekjoon.dijkstra

import java.io.ByteArrayInputStream
import java.util.*

fun main() {
    val inputs = listOf(
        "5\n8\n1 2 2\n1 3 3\n1 4 1\n1 5 10\n2 4 2\n3 4 1\n3 5 1\n4 5 3\n1 5"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().toInt() to readLine().toInt()
    val graph = hashMapOf<Int, MutableList<Vertex>>()
    val durations = IntArray(n) { Int.MAX_VALUE }
    val pq = PriorityQueue<Vertex>(compareBy { it.time })

    repeat(m) {
        val (s, d, t) = readLine().split(" ").map { it.toInt() }

        graph.getOrPut(s) { mutableListOf() }.add(Vertex(d, t))
    }
    val (s, e) = readLine().split(" ").map { it.toInt() }

    durations[s - 1] = 0
    pq.add(Vertex(s, 0, listOf(s)))

    while (pq.isNotEmpty()) {
        val c = pq.poll()

        if (c.destination == e) {
            println(durations[e-1])
            println(c.path.size)
            println(c.path.joinToString(" "))
            break
        }

        if (c.time > durations[c.destination - 1]) continue

        for (d in graph[c.destination] ?: emptyList()) {
            val newTime = c.time + d.time

            if (durations[d.destination - 1] > newTime) {
                durations[d.destination - 1] = newTime
                pq.add(Vertex(d.destination, newTime, c.path + d.destination))
            }
        }
    }
}

private data class Vertex(
    val destination: Int,
    val time: Int,
    val path: List<Int> = emptyList(),
)

// https://www.acmicpc.net/problem/11779