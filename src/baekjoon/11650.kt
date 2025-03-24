package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n3 4\n1 1\n1 -1\n2 2\n3 3",
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    println(MutableList(readLine().toInt()) {
        readLine()
            .split(" ")
            .map { it.toInt() }
    }
        .apply {
            sortWith(
                compareBy(
                    { it.first() },
                    { it.last() }
                )
            )
        }.joinToString("\n") { "${it.first()} ${it.last()}" })
}

// https://www.acmicpc.net/problem/11650