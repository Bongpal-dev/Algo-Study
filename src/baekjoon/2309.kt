package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "20\n7\n23\n19\n10\n15\n25\n8\n13"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val inputs = List(9) { readLine().toInt() }
    val answer = mutableListOf<List<Int>>()

    find(0, 0, mutableListOf(), inputs, answer)
    println(answer.first().sorted().joinToString("\n"))
}

private fun find(i: Int, sum: Int, visited: MutableList<Int>, dwarfs: List<Int>, answer: MutableList<List<Int>>) {
    if (sum == 100 && visited.size == 7) { answer.add(visited.toList()) }
    if (sum > 100) return

    for (d in i..dwarfs.lastIndex) {
        visited.add(dwarfs[d])
        find(d + 1, sum + dwarfs[d], visited, dwarfs, answer)
        visited.removeLast()
    }
}

// https://www.acmicpc.net/problem/2309