package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5 3\n5 4 3 2 1\n1 3\n2 4\n5 5"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    readLine()

    val nums = readLine().split(" ").map { it.toInt() }
    var sums = mutableListOf(0)

    nums.fold(0) { acc, v -> (acc + v).also { sums += it } }
    readLines()
        .map { q ->
            val (i, j) = q.split(" ").map { it.toInt() }
            sums[j] - sums[i - 1]
        }
        .joinToString("\n")
        .run(::println)
}

// https://www.acmicpc.net/problem/11659