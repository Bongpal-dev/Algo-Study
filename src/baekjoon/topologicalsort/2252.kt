package baekjoon.topologicalsort

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3 2\n1 3\n2 3",
        "4 2\n4 2\n3 1"
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

    val inDegree = IntArray(n) { 0 }
    val graph = hashMapOf<Int, MutableList<Int>>()
    val result = StringBuilder()

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        graph.getOrPut(a-1) { mutableListOf() }.add(b-1)
        inDegree[b - 1]++
    }

    val queue = mutableListOf<Int>()

    inDegree.forEachIndexed { i, v ->
        if (v == 0) {
            queue.add(i)
        }
    }

    while (queue.isNotEmpty()) {
        val c = queue.removeFirst()

        result.append("${c + 1} ")

        (graph[c] ?: emptyList()).forEach { s ->
            inDegree[s]--

            if (inDegree[s] == 0) {
                queue.add(s)
            }
        }
    }

    println(result.toString())
}

// https://www.acmicpc.net/problem/2252