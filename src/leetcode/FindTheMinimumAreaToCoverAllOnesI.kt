package leetcode

fun main() {
    val grid1 = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(1, 0, 1),
    )
    val grid2 = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 0),
    )

    println(minimumArea(grid1))
    println(minimumArea(grid2))
}

private fun minimumArea(grid: Array<IntArray>): Int {
    var l = 0
    var r = grid[0].size - 1
    var t = 0
    var b = grid.size - 1

    for (i in grid.indices) {
        if (grid[i].all { it == 0 }) t++ else break
    }

    for (i in grid.lastIndex downTo 0) {
        if (grid[i].all { it == 0 }) b-- else break
    }

    loop1@ for (j in l..r) {
        for (k in t..b) {
            if (grid[k][j] == 1) break@loop1
        }
        l++
    }

    loop2@ for (n in r downTo l) {
        for (m in t..b) {
            if (grid[m][n] == 1) break@loop2
        }
        r--
    }

    return ((r - l) + 1) * ((b - t) + 1)
}

// https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description