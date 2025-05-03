package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5"
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
    val sb = StringBuilder()

    for (i in n downTo 1) {
        repeat(i) { sb.append("*") }

        if (i > 1) sb.append("\n")
    }
    println(sb)
}

// https://www.acmicpc.net/problem/2440