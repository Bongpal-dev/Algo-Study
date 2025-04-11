package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
//        "6 5\n1 2\n2 5\n5 1\n3 4\n4 6",
//        "6 8\n1 2\n2 5\n5 1\n3 4\n4 6\n5 4\n2 4\n2 3",
//        "3 1\n3 2",
//        "6 4\n1 2\n2 3\n4 5\n5 6",
        "5 0"
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
    val graph = hashMapOf<Int, MutableList<Int>>()

    readLines().forEach { node ->
        val (u, v) = node.split(" ").map { it.toInt() }

        graph.getOrPut(u) { mutableListOf() }.add(v)
        graph.getOrPut(v) { mutableListOf() }.add(u)
    }

    var answer = 0
    val visited = BooleanArray(n + 1).apply { this[0] = true }
    var current = graph.keys.firstOrNull() ?:1

    while (visited.any { it.not() }) {
        dfs(current, visited, graph)
        answer++
        current = visited.indexOfFirst { it.not() }
    }
    println(answer)
}

private fun dfs(s: Int, visited: BooleanArray, graph: HashMap<Int, MutableList<Int>>) {
    if (visited[s]) return

    visited[s] = true

    for (n in graph[s] ?: emptyList()) {
        dfs(n, visited, graph)
    }
}

// https://www.acmicpc.net/problem/11724