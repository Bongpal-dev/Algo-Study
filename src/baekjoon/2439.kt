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

    for (i in 1..n) {
        repeat(n - i) { sb.append(" ") }
        repeat(i) { sb.append("*") }

        if(i < n) sb.append("\n")
    }
    println(sb)
}

// https://www.acmicpc.net/problem/2439