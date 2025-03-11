package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "7 3"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val answer = mutableListOf<Int>()
    val persons = MutableList(n) { it + 1 }
    var i = 0

    while (persons.isNotEmpty()) {
        i = (i + k - 1) % persons.size
        answer.add(persons.removeAt(i))
    }

    print(answer.joinToString(prefix = "<", postfix = ">"))
}

// https://www.acmicpc.net/problem/1158