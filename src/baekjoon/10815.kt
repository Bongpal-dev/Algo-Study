package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n6 3 2 10 -10\n8\n10 9 -5 2 3 4 5 -10"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    readLines().let { line ->
        val cards = line[1].split(" ").associateBy { it }
        val answer = line[3].split(" ").map { if (cards[it] != null) 1 else 0 }

        println(answer.joinToString(" "))
    }
}

// https://www.acmicpc.net/problem/10815