package baekjoon.backtracking

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5 0\n-7 -3 -2 5 8"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }

    println(find(0, s, 0, arr))
}

private fun find(i: Int, target: Int, sum: Int, arr: List<Int>): Int {
    var count = 0

    if (i > 0 && sum == target) count++

    for (j in i..arr.lastIndex) {
        count += find(j + 1, target, sum + arr[j], arr)
    }

    return count
}

// https://www.acmicpc.net/problem/1182