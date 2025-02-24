package shortestpath

import java.util.PriorityQueue

fun main() {
    val (times1, n1, k1) = Triple(arrayOf(intArrayOf(2, 1, 1), intArrayOf(2, 3, 1), intArrayOf(3, 4, 1)), 4, 2)
    val (times2, n2, k2) = Triple(arrayOf(intArrayOf(1, 2, 1)), 2, 1)
    val (times3, n3, k3) = Triple(arrayOf(intArrayOf(1, 2, 1)), 2, 2)
    val (times4, n4, k4) = Triple(arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 1, 3)), 2, 2)

    println(networkDelayTime(times1, n1, k1))
    println(networkDelayTime(times2, n2, k2))
    println(networkDelayTime(times3, n3, k3))
    println(networkDelayTime(times4, n4, k4))
}

private data class Vertex(
    val target: Int,
    val time: Int
)

private fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val duration = IntArray(n + 1) { Int.MAX_VALUE }
    val queue = PriorityQueue<Vertex>(compareBy { it.time })
    val graph = hashMapOf<Int, MutableList<Vertex>>()

    times.forEach {
        graph.getOrPut(it[0]) { mutableListOf() }.add(Vertex(it[1], it[2]))
    }

    duration[k] = 0
    queue.add(Vertex(k, 0))

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        if (current.time > duration[current.target]) continue

        for (t in graph[current.target] ?: emptyList()) {
            val newTime = current.time + t.time

            if (newTime < duration[t.target]) {
                duration[t.target] = newTime
                queue.add(Vertex(t.target, newTime))
            }
        }
    }

    duration.slice(1..n).let { g ->
        return if (g.any { it == Int.MAX_VALUE}) -1 else g.maxOrNull() ?: -1
    }
}

// https://leetcode.com/problems/network-delay-time/description/