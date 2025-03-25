package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n2 4 -10 4 -9",
        "6\n1000 999 1000 999 1000 999"
    )
    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val nums = readLines()[1].split(" ").map { it.toInt() }
    val numsCounts = hashMapOf<Int, Int>()

    nums.toSortedSet().forEachIndexed { i, n -> numsCounts[n] = i }
    nums.map { numsCounts.getOrDefault(it, 0) }.joinToString(" ").run(::println)
}

// https://www.acmicpc.net/problem/18870