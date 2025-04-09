package baekjoon

import java.io.ByteArrayInputStream
import kotlin.math.sqrt

fun main() {
    val inputs = listOf(
        "3\n1 45000\n6 10\n13 17",
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<Int>()
    val nums = List(readLine().toInt()) { readLine().split(" ").map { it.toInt() } }

    nums.forEach { answer += (it[0] * it[1]) / gcd(it[0], it[1]) }
    println(answer.joinToString("\n"))
}

private fun gcd(num1: Int, num2: Int): Int {
    var l = minOf(num1, num2)
    var h = maxOf(num1, num2)

    while (l > 0 && h > 0) {
        if (l < h) h %= l else l %= h
    }

    return maxOf(l, h)
}

// https://www.acmicpc.net/problem/1934