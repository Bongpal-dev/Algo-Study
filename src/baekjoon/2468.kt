package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n6 8 2 6 2\n3 2 3 4 6\n6 7 3 3 2\n7 2 5 3 6\n8 9 5 2 7",
        "7\n9 9 9 9 9 9 9\n9 2 1 2 1 2 9\n9 1 8 7 8 1 9\n9 2 7 9 7 2 9\n9 1 8 7 8 1 9\n9 2 1 2 1 2 9\n9 9 9 9 9 9 9"
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
    val area = List(n) { readLine().split(" ").map { it.toInt() } }
    val maxH = area.maxOf { it.max() }
    var result = 0

    for (i in 0..maxH) {
        result = maxOf(result, area.countSafeArea(i))
    }

    println(result)
}

private fun List<List<Int>>.countSafeArea(i: Int): Int {
    val visited = this.map { it.map { c -> c <= i }.toMutableList() }
    var result = 0

    for(y in visited.indices) {
        for(x in visited[0].indices) {
            if(visited[y][x].not()) {
                find(x, y, this, visited)
                result++
            }
        }
    }

    return result
}

private fun find(x: Int, y: Int, map: List<List<Int>>, visited: List<MutableList<Boolean>>) {
    if(x !in 0 .. map[0].lastIndex || y !in 0 .. map.lastIndex || visited[y][x]) return

    visited[y][x] = true

    find(x+1, y, map, visited)
    find(x-1, y, map, visited)
    find(x, y+1, map, visited)
    find(x, y-1, map, visited)
}

// https://www.acmicpc.net/problem/2468