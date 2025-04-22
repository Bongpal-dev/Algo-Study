package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n14\n1 2 2\n1 3 3\n1 4 1\n1 5 10\n2 4 2\n3 4 1\n3 5 1\n4 5 3\n3 5 10\n3 1 8\n1 4 2\n5 1 7\n3 4 2\n5 2 4"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    val m = readLine().toInt()
    val durations = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }

    for (i in 1..n) durations[i][i] = 0

    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }

        durations[a][b] = minOf(durations[a][b], c)
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (durations[i][k] < Int.MAX_VALUE && durations[k][j] < Int.MAX_VALUE) {
                    durations[i][j] = minOf(durations[i][j], durations[i][k] + durations[k][j])
                }
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            val time = if (durations[i][j] == Int.MAX_VALUE)"0" else durations[i][j].toString()

            sb.append("$time ")
        }
        sb.append("\n")
    }

    println(sb)
}

// https://www.acmicpc.net/problem/11404