package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "8\n1 1 0 0 0 0 1 1\n1 1 0 0 0 0 1 1\n0 0 0 0 1 1 0 0\n0 0 0 0 1 1 0 0\n1 0 0 0 1 1 1 1\n0 1 0 0 1 1 1 1\n0 0 1 1 1 1 1 1\n0 0 1 1 1 1 1 1"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val p = List(readLine().toInt()) { readLine().split(" ").map { it.toInt() } }
    val answer = mutableListOf(0, 0)

    find(0, 0, p.size, p, answer)

    println(answer.joinToString("\n"))
}

private fun find(x: Int, y: Int, size: Int, p: List<List<Int>>, answer: MutableList<Int>) {
    val color = p[x][y]
    var isSame = true

    loop@ for (i in x until x + size) {
        for (j in y until y + size) {
            if (p[i][j] != color) {
                isSame = false
                break@loop
            }
        }
    }

    if (isSame) {
        answer[color]++
    } else {
        val half = size / 2

        find(x, y, half, p, answer)
        find(x, y + half, half, p, answer)
        find(x + half, y, half, p, answer)
        find(x + half, y + half, half, p, answer)
    }
}

// https://www.acmicpc.net/problem/2630