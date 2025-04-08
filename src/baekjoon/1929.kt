package baekjoon

import java.io.ByteArrayInputStream
import kotlin.math.sqrt

fun main() {
    val inputs = listOf(
        "3 16",
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val isPrime = MutableList(n + 1) { true }

    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..n step i) {
                isPrime[j] = false
            }
        }
    }

    println(isPrime.mapIndexedNotNull { i, v -> if (i >= m && v) i else null }.joinToString("\n"))
}

// https://www.acmicpc.net/problem/1929