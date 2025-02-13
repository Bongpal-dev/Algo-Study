package graph

fun main() {
    val grid1 = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0'),
    )
    val grid2 = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1'),
    )

    println(numIslands(grid1))
    println(numIslands(grid2))
}

private fun numIslands(grid: Array<CharArray>): Int {
    var count = 0

    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (grid[r][c] == '1') {
                count++
                changeIslandState(r, c, grid)
            }
        }
    }

    return count
}

private fun changeIslandState(row: Int, col: Int, grid: Array<CharArray>) {
    val (rowSize, colSize) = grid.size to grid[0].size

    if (row < 0 || col < 0 || row >= rowSize || col >= colSize || grid[row][col] == '0') return

    grid[row][col] = '0'

    changeIslandState(row - 1, col, grid)
    changeIslandState(row + 1, col, grid)
    changeIslandState(row, col - 1, grid)
    changeIslandState(row, col + 1, grid)
}

// https://leetcode.com/problems/number-of-islands/