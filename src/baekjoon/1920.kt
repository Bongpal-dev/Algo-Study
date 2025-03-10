package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n4 1 5 2 3\n5\n1 3 7 9 5"
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
    val aList = readLine().split(" ").associateBy { it }
    readLine()
    val xList = readLine().split(" ")

    xList.forEach { println(if (aList[it] != null) 1 else 0) }
}

// https://www.acmicpc.net/problem/1920