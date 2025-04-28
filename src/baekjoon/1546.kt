package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3\n40 80 60",
        "3\n10 20 30",
        "4\n1 100 100 100",
        "5\n1 2 4 8 16",
        "2\n3 10",
        "4\n10 20 0 100",
        "1\n50",
        "9\n10 20 30 40 50 60 70 80 90"
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
    val s = readLine().split(" ").map { it.toDouble() }
    val maxScore = s.max()

    println(s.sumOf { (it / maxScore) * 100 } / n)
}

// https://www.acmicpc.net/problem/1546