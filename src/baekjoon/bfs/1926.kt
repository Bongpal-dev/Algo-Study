package baekjoon.bfs

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "6 5\n1 1 0 1 1\n0 1 1 0 0\n0 0 0 0 0\n1 0 1 1 1\n0 0 1 1 1\n0 0 1 1 1"
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
    val painter = Array(n) { readLine().split(" ").toMutableList() }
    var count = 0
    var area = 0

    for (p in painter.indices) {
        for (q in painter[p].indices) {
            if (painter[p][q] == "1") {
                count++
                area = maxOf(area, fill(p, q, n, m, painter))
            }
        }
    }

    println(count)
    println(area)
}

private fun fill(col: Int, row: Int, n: Int, m: Int, painter: Array<MutableList<String>>): Int {
    if (col < 0 || col > n - 1 || row < 0 || row > m - 1 || painter[col][row] == "0") return 0

    var count = 0

    painter[col][row] = "0"
    count++

    count += fill(col - 1, row, n, m, painter)
    count += fill(col + 1, row, n, m, painter)
    count += fill(col, row - 1, n, m, painter)
    count += fill(col, row + 1, n, m, painter)

    return count
}

// https://www.acmicpc.net/problem/1926