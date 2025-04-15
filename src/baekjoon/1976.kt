package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3\n3\n0 1 0\n1 0 1\n0 1 0\n1 2 3",
        "4\n4\n0 1 0 0\n1 0 1 0\n0 1 0 1\n0 0 1 0\n1 2 3 4"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val routes = List(n) { readLine().split(" ").map { it.toInt() } }
    val plan = readLine().split(" ").map { it.toInt() }
    val root = IntArray(n + 1) { it }

    fun find(n: Int): Int {
        if (root[n] != n) {
            root[n] = find(root[n])
        }
        return root[n]
    }

    fun union(a: Int, b: Int) {
        val rootA = find(a)
        val rootB = find(b)

        if (rootA != rootB) {
            root[rootB] = rootA
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (routes[i][j] == 1) {
                union(i + 1, j + 1)
            }
        }
    }

    println(if (plan.map { find(it) }.toSet().size == 1) "YES" else "NO")
}

// https://www.acmicpc.net/problem/1976