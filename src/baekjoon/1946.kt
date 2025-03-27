package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "2\n5\n3 2\n1 4\n4 1\n2 3\n5 5\n7\n3 6\n7 3\n4 2\n1 4\n5 7\n2 5\n6 1"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    fun readInt() = readLine().toInt()
    fun readIntList() = readLine().split(" ").map { it.toInt() }

    val answer = mutableListOf<Int>()
    val tc = List(readInt()) { List(readInt()) { readIntList() }.sortedBy { it.first() } }

    tc.forEach { case ->
        var cutLine = 100001
        var count = 0

        case.forEach {
            if (it.last() < cutLine) {
                count++
                cutLine = it.last()
            }
        }
        answer += count
    }

    println(answer.joinToString("\n"))
}

// https://www.acmicpc.net/problem/1946