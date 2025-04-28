package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "7 7\n2 0 0 0 1 1 0\n0 0 1 0 1 2 0\n0 1 1 0 1 0 0\n0 1 0 0 0 0 0\n0 0 0 0 0 1 1\n0 1 0 0 0 0 0\n0 1 0 0 0 0 0",
        "4 6\n0 0 0 0 0 0\n1 0 0 0 0 2\n1 1 1 0 0 2\n0 0 0 0 0 2",
        "8 8\n2 0 0 0 0 0 0 2\n2 0 0 0 0 0 0 2\n2 0 0 0 0 0 0 2\n2 0 0 0 0 0 0 2\n2 0 0 0 0 0 0 2\n0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0\n0 0 0 0 0 0 0 0"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

data class Point(
    val x: Int,
    val y: Int,
)

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val lab = List(n) { readLine().split(" ").map { it.toInt() } }
    val empty = mutableListOf<Point>()
    var max = 0

    for (y in lab.indices) {
        for (x in lab[0].indices) {
            if (lab[y][x] == 0) empty += Point(x, y)
        }
    }

    val result = empty
        .combine()
        .maxOf { it.findSafeArea(lab) }

    println(result)
}

private fun MutableList<Point>.combine(): List<List<Point>> {
    val result = mutableListOf<List<Point>>()

    for (i in 0..this.lastIndex) {
        for (j in i + 1..this.lastIndex) {
            for (k in j + 1..this.lastIndex) {
                result += listOf(this[i], this[j], this[k])
            }
        }
    }

    return result
}

private fun List<Point>.findSafeArea(lab: List<List<Int>>): Int {
    val currentLab = lab.map { it.toMutableList() }

    this.forEach { currentLab[it.y][it.x] = 1 }
    currentLab.forEachIndexed { y, row ->
        row.forEachIndexed { x, v ->
            if (v == 2) {
                currentLab.diffuse(x + 1, y)
                currentLab.diffuse(x - 1, y)
                currentLab.diffuse(x, y + 1)
                currentLab.diffuse(x, y - 1)
            }
        }
    }

    return currentLab.sumOf { row -> row.count { it == 0 } }
}

private fun List<MutableList<Int>>.diffuse(x: Int, y: Int) {
    if (x < 0 || y < 0 || x > this[0].lastIndex || y > this.lastIndex || this[y][x] != 0) return

    if (this[y][x] == 0) this[y][x] = 2

    diffuse(x + 1, y)
    diffuse(x - 1, y)
    diffuse(x, y + 1)
    diffuse(x, y - 1)
}

// https://www.acmicpc.net/problem/14502