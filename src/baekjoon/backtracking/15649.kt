package baekjoon.backtracking

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3 1", "4 2", "4 4"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val answer = mutableListOf<List<Int>>()
    val current = mutableListOf<Int>()

    generate(n, m, current, answer)

    println(answer.joinToString("\n") { it.joinToString(" ") })
}

private fun generate(n: Int, m: Int, current: MutableList<Int>, answer: MutableList<List<Int>>) {
    if (current.size >= m) {
        answer.add(current.toList())
        return
    }

    for (i in 1..n) {
        if (current.contains(i).not()) {
            current.add(i)
            generate(n, m, current, answer)
            current.removeLast()
        }
    }
}

// https://www.acmicpc.net/problem/15649