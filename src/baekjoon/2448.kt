package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "24"
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
    val map = Array(n) { CharArray(2 * n) { ' ' } }

    draw(map, n, 0, n - 1)
    map.forEach { println(it.joinToString("")) }
}

fun draw(map: Array<CharArray>, size: Int, row: Int, col: Int) {
    if (size == 3) {
        map[row][col] = '*'

        map[row + 1][col - 1] = '*'
        map[row + 1][col + 1] = '*'

        for (i in -2..2) {
            map[row + 2][col + i] = '*'
        }

        return
    }

    val half = size / 2

    draw(map, half, row, col)
    draw(map, half, row + half, col - half)
    draw(map, half, row + half, col + half)
}

// https://www.acmicpc.net/problem/2448