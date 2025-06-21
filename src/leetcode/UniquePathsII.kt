package leetcode

fun main() {
    val obstacleGrid1 = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0),
    )
    val obstacleGrid2 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 0),
    )

    println(uniquePathsWithObstacles(obstacleGrid1))
    println(uniquePathsWithObstacles(obstacleGrid2))
}

private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val grid = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) }

    for (y in grid.indices) {
        for (x in grid[0].indices) {
            when {
                y == 0 && x == 0 -> grid[y][x] = if (obstacleGrid[y][x] == 0) 1 else 0
                obstacleGrid[y][x] == 1 -> grid[y][x] = 0
                y == 0 -> grid[y][x] = grid[y][x - 1]
                x == 0 -> grid[y][x] = grid[y - 1][x]
                else -> grid[y][x] = grid[y - 1][x] + grid[y][x - 1]
            }
        }
    }

    return grid[grid.size - 1][grid[0].size - 1]
}

// https://leetcode.com/problems/unique-paths-ii/description/