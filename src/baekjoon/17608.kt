package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "6\n6\n9\n7\n6\n4\n6",
        "5\n5\n4\n3\n2\n1"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val stack = mutableListOf(Int.MIN_VALUE)

    readLines()
        .reversed()
        .dropLast(1)
        .forEach { n ->
            if (stack.last() < n.toInt()) stack.add(n.toInt())
        }
    print(stack.size - 1)
}

// https://www.acmicpc.net/problem/17608