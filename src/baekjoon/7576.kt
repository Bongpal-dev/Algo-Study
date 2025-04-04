package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "6 4\n0 0 0 0 0 0\n0 0 0 0 0 0\n0 0 0 0 0 0\n0 0 0 0 0 1",
        "6 4\n0 -1 0 0 0 0\n-1 0 0 0 0 0\n0 0 0 0 0 0\n0 0 0 0 0 1",
        "6 4\n1 -1 0 0 0 0\n0 -1 0 0 0 0\n0 0 0 0 -1 0\n0 0 0 0 -1 1",
        "5 5\n-1 1 0 0 0\n0 -1 -1 -1 0\n0 -1 -1 -1 0\n0 -1 -1 -1 0\n0 0 0 0 0",
        "2 2\n1 -1\n-1 1"
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
    var queue = ArrayDeque<Node>()
    var answer = 0
    val box = List(n) { readLine().split(" ").map { it.toInt() }.toMutableList() }

    box.forEachIndexed { y, v ->
        v.forEachIndexed { x, w ->
            if (w == 1) {
                queue.add(Node(x, y, 0))
            }
        }
    }

    fun addQueue(x: Int, y: Int, day: Int) {
        if (x !in 0..box[0].lastIndex || y !in 0..box.lastIndex) return

        if (box[y][x] == 0) {
            box[y][x] = 1
            queue += Node(x, y, day + 1)
        }
    }

    while (queue.isNotEmpty()) {
        val (x, y, day) = queue.removeFirst()

        answer = maxOf(day, day)
        addQueue(x + 1, y, day)
        addQueue(x - 1, y, day)
        addQueue(x, y + 1, day)
        addQueue(x, y - 1, day)
    }

    println(if (box.any { it.contains(0) }) -1 else answer)
}

private data class Node(
    val x: Int,
    val y: Int,
    val day: Int
)

// https://www.acmicpc.net/problem/7576