package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "4 5 1\n1 2\n1 3\n1 4\n2 4\n3 4",
        "5 5 3\n5 4\n5 2\n1 2\n3 4\n3 1",
        "1000 1 1000\n999 1000"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val graph = hashMapOf<Int, MutableList<Int>>()
    val (n, m, v) = readLine().split(" ").map { it.toInt() }
    val (dfsResult, bfsResult) = mutableListOf<Int>() to mutableListOf<Int>()

    repeat(m) {
        val (n, e) = readLine().split(" ").map { it.toInt() }

        graph.getOrPut(n) { mutableListOf() }.apply { add(e); sort() }
        graph.getOrPut(e) { mutableListOf() }.apply { add(n); sort() }
    }

    dfs(v, graph, dfsResult, IntArray(n) { 0 })
    bfs(v, graph, bfsResult, IntArray(n) { 0 })

    println("${dfsResult.joinToString(" ")}\n${bfsResult.joinToString(" ")}")
}

private fun dfs(node: Int, graph: HashMap<Int, MutableList<Int>>, result: MutableList<Int>, visited: IntArray) {
    if (visited[node - 1] == 1) return

    result.add(node)
    visited[node - 1] = 1

    for (n in graph[node] ?: emptyList()) {
        if (visited[n - 1] == 0) {
            dfs(n, graph, result, visited)
        }
    }
}

private fun bfs(node: Int, graph: HashMap<Int, MutableList<Int>>, result: MutableList<Int>, visited: IntArray) {
    val stack = mutableListOf<Int>()

    stack.add(node)

    while (stack.isNotEmpty()) {
        val current = stack.removeFirst()

        if (visited[current - 1] == 1) continue

        result.add(current)
        visited[current - 1] = 1

        for (n in graph[current] ?: emptyList()) {
            if (visited[n - 1] == 0) stack.add(n)
        }
    }
}

// https://www.acmicpc.net/problem/1260