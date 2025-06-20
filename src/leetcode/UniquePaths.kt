package leetcode

fun main() {
    val (m1, n1) = 3 to 7
    val (m2, n2) = 3 to 2

    println(uniquePaths(m1, n1))
    println(uniquePaths(m2, n2))
}

private fun uniquePaths(m: Int, n: Int): Int {
    val grid = Array(m) { IntArray(n) }

    for (y in grid.indices) {
        for(x in grid[0].indices) {
            if(y == 0 || x == 0) {
                grid[y][x] = 1
                continue
            }

            grid[y][x] = grid[y-1][x] + grid[y][x-1]
        }
    }

    return grid[m-1][n-1]
}

// https://leetcode.com/problems/unique-paths/description/