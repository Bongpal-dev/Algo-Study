package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3 3\n1 2 1\n2 3 2\n1 3 3"
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
    val unionFind = UnionFind(v)
    val edges =
        List(e) { readLine().split(" ").map { it.toInt() }.let { (a, b, c) -> Edge2(a, b, c) } }.sortedBy { it.weight }
    var answer = 0
    var count = 0

    for (e in edges) {
        if (unionFind.union(e.start, e.destination)) {
            answer += e.weight
            count++

            if (count == v -1) break
        }
    }
    println(answer)
}

private class UnionFind(nodeCount: Int) {
    private val parent = IntArray(nodeCount + 1) { it }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])

        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        return if (rootX == rootY) {
            false
        } else {
            parent[rootY] = rootX
            true
        }
    }
}

private data class Edge2(
    val start: Int,
    val destination: Int,
    val weight: Int
)

// https://www.acmicpc.net/problem/1197