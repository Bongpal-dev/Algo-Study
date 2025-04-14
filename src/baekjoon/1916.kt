package baekjoon

import java.io.ByteArrayInputStream
import java.time.Period
import java.util.PriorityQueue

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
    val visited = MutableList(readLine().toInt() + 1) { Int.MAX_VALUE }
    val graph = hashMapOf<Int, MutableList<Edge>>()

    repeat(readLine().toInt()) {
        val (s, d, c) = readLine().split(" ").map { it.toInt() }

        graph.getOrPut(s) { mutableListOf() }.add(Edge(d, c))
    }

    val (start, target) = readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Edge>(compareBy { it.cost })

    visited[start] = 0
    pq.add(Edge(start, 0))

    while (pq.isNotEmpty()) {
        val current = pq.poll()

        if (visited[current.destination] < current.cost) continue

        for(n in graph[current.destination] ?: emptyList()) {
            val newCost = current.cost + n.cost

            if (newCost < visited[n.destination]) {
                visited[n.destination] = newCost
                pq.add(Edge(n.destination, newCost))
            }
        }
    }
    println(visited[target])
}

private data class Edge(
    val destination: Int,
    val cost: Int
)

// https://www.acmicpc.net/problem/1916