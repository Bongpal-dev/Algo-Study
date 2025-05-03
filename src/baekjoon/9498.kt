package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "100"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    when(readLine().toInt()) {
        in 90 .. 100 -> "A"
        in 80 .. 89 -> "B"
        in 70 .. 79 -> "C"
        in 60 .. 69 -> "D"
        else -> "F"
    }.run(::println)
}

// https://www.acmicpc.net/problem/9498