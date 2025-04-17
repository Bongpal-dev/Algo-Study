package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "2\n3 2\n1 3\n2 3\n4 4\n1 2\n2 3\n3 4\n4 2"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<String>()
    val k = readLine().toInt()

    repeat(k) {
        val (vs, e) = readLine().split(" ").map { it.toInt() }
        val graph = hashMapOf<Int, MutableList<Int>>()

        repeat(e) {
            val (u, v) = readLine().split(" ").map { it.toInt() }

            graph.getOrPut(u) { mutableListOf() }.add(v)
            graph.getOrPut(v) { mutableListOf() }.add(u)
        }

        val visited = IntArray(vs + 1)
        var bipartite = true

        for (i in 1 .. vs) {
            if (visited[i] == 0) {
                if (isBipartite(i, 1, visited, graph).not()){
                    bipartite = false
                    break
                }
            }
        }

        answer += if (bipartite) "YES" else "NO"
    }
    println(answer.joinToString("\n"))
}

private fun isBipartite(v: Int, part: Int, visited: IntArray, graph: HashMap<Int, MutableList<Int>>): Boolean {
    visited[v] = part

    for (n in graph[v] ?: emptyList()) {
        if (visited[n] == 0) {
            if (isBipartite(n, 3 - part, visited, graph).not()) return false
        } else if (visited[n] == part) {
            return false
        }
    }

    return true
}

// https://www.acmicpc.net/problem/1707