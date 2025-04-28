package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n3 1 4 3 2"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val p = readLine().split(" ").map { it.toInt() }
    var result = 0
    var sum = 0

    p.sorted().forEach {
        sum += it
        result += sum
    }

    println(result)
}

// https://www.acmicpc.net/problem/11399