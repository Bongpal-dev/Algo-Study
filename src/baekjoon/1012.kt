package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "2\n10 8 17\n0 0\n1 0\n1 1\n4 2\n4 3\n4 5\n2 4\n3 4\n7 4\n8 4\n9 4\n7 5\n8 5\n9 5\n7 6\n8 6\n9 6\n10 10 1\n5 5",
        "1\n5 3 6\n0 2\n1 2\n2 2\n3 2\n4 2\n4 0"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<Int>()

    repeat(readLine().toInt()) {
        val (m, n, k) = readLine().split(" ").map { it.toInt() }
        val farm = Array(n) { IntArray(m) { 0 } }
        var count = 0

        repeat(k) { readLine().split(" ").map { it.toInt() }.let { (x, y) -> farm[y][x] = 1 } }

        farm.forEachIndexed { y, row ->
            for (x in row.indices) {
                if (farm[y][x] == 1) {
                    count++
                    count(farm, x, y)
                }
            }
        }
        answer += count
    }
    println(answer.joinToString("\n"))
}

private fun count(farm: Array<IntArray>, x: Int, y: Int) {
    if (x !in 0..farm[0].lastIndex || y !in 0..farm.lastIndex || farm[y][x] == 0) return

    farm[y][x] = 0
    count(farm, x + 1, y)
    count(farm, x - 1, y)
    count(farm, x, y + 1)
    count(farm, x, y - 1)
}

// https://www.acmicpc.net/problem/1012