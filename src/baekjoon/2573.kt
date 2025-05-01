package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5 7\n0 0 0 0 0 0 0\n0 2 4 5 3 0 0\n0 3 0 2 5 2 0\n0 7 6 2 4 0 0\n0 0 0 0 0 0 0",
        "8 5\n0 0 0 0 0\n0 0 1 0 0\n0 1 9 1 0\n0 0 1 0 0\n0 0 1 0 0\n0 1 9 1 0\n0 0 1 0 0\n0 0 0 0 0", // 1
        "5 5\n0 0 0 0 0\n0 0 0 0 0\n0 5 0 5 0\n0 0 0 0 0\n0 0 0 0 0", // 0
        "5 5\n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0\n0 0 0 0 0", // 0
        "4 4\n0 0 0 0\n0 3 1 0\n0 1 3 0\n0 0 0 0\n1", // 1
        "5 7\n0 0 0 0 0 0 0\n0 10 10 10 10 10 0\n0 10 0 1 0 10 0\n0 10 10 10 10 10 0\n0 0 0 0 0 0 0", // 5
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val iceBerg = List(n) { readLine().split(" ").map { it.toInt() } }

    println(countYear(iceBerg))
}

private fun countYear(iceBerg: List<List<Int>>): Int {
    val current = iceBerg.map { it.toMutableList() }
    var year = 0

    while (true) {
        if (current.hasNoIce()) return 0
        if (current.isSeparate()) return year

        year++
        current.meltIce()
    }
}

private fun List<MutableList<Int>>.hasNoIce() = this.all { row -> row.all { it == 0 } }

private fun List<MutableList<Int>>.isSeparate(): Boolean {
    var count = 0
    val visited = this.map { it.map { c -> c < 1 }.toBooleanArray() }

    for (y in this.indices) {
        for (x in this[0].indices) {
            if (visited[y][x].not()) {
                find(x, y, this, visited)
                count++
            }
        }
    }

    return count > 1
}

private fun List<MutableList<Int>>.meltIce() {
    val meltValues = List(this.size) { IntArray(this[0].size) }

    for (y in this.indices) {
        for (x in this[0].indices) {
            if (this[y][x] > 0) {
                var sum = 0

                sum += if (y > 0 && this[y - 1][x] == 0) 1 else 0
                sum += if (y < this.lastIndex && this[y + 1][x] == 0) 1 else 0
                sum += if (x > 0 && this[y][x - 1] == 0) 1 else 0
                sum += if (x < this[0].lastIndex && this[y][x + 1] == 0) 1 else 0

                meltValues[y][x] += sum
            }
        }
    }

    for (y in this.indices) {
        for (x in this[0].indices) {
            this[y][x] = (this[y][x] - meltValues[y][x]).coerceAtLeast(0)
        }
    }
}

private fun find(x: Int, y: Int, ib: List<MutableList<Int>>, visited: List<BooleanArray>) {
    if (x !in 0..ib[0].lastIndex || y !in 0..ib.lastIndex || visited[y][x]) return

    visited[y][x] = true

    find(x + 1, y, ib, visited)
    find(x - 1, y, ib, visited)
    find(x, y + 1, ib, visited)
    find(x, y - 1, ib, visited)
}

// https://www.acmicpc.net/problem/2573