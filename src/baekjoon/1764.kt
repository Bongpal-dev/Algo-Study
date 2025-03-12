package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "3 4\nohhenrie\ncharlie\nbaesangwook\nobama\nbaesangwook\nohhenrie\nclinton"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<String>()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val noListen = hashMapOf<String, Int>()

    repeat(n) {
        noListen[readLine().trim()] = 0
    }
    readLines().forEach {
        if (noListen[it.trim()] != null) answer.add(it)
    }
    answer.sort()
    println(answer.size)
    println(answer.joinToString("\n"))
}

// https://www.acmicpc.net/problem/1764