package leetcode

fun main() {
    val grid1 = arrayOf(intArrayOf(4, 3, 8, 4), intArrayOf(9, 5, 1, 9), intArrayOf(2, 7, 6, 2))
    val grid2 = arrayOf(intArrayOf(8))
    val grid3 = arrayOf(intArrayOf(5, 5, 5), intArrayOf(5, 5, 5), intArrayOf(5, 5, 5))

    println(numMagicSquaresInside(grid1))
    println(numMagicSquaresInside(grid2))
    println(numMagicSquaresInside(grid3))
}

private fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    var ans = 0

    for (y in 0..grid.size - 3) {
        for (x in 0..grid[y].size - 3) {
            if (grid.checkMagicSquares(x, y)) ans++
        }
    }

    return ans
}

private fun Array<IntArray>.checkMagicSquares(x: Int, y: Int): Boolean {
    if (this.isValidRange(x, y).not()) return false
    if (this.validDiag(x, y).not()) return false

    for (i in y..y + 2) {
        if (this[i][x] + this[i][x + 1] + this[i][x + 2] != 15) return false
    }

    for (j in x..x + 2) {
        if (this[y][j] + this[y + 1][j] + this[y + 2][j] != 15) return false
    }

    return true
}

private fun Array<IntArray>.isValidRange(x: Int, y: Int): Boolean {
    val nums = BooleanArray(9)

    for (i in y..y + 2) {
        for (j in x..x + 2) {
            val current = this[i][j]

            when {
                current !in (1..9) -> return false
                nums[current - 1] -> return false
                else -> nums[current - 1] = true
            }
        }
    }

    return true
}

private fun Array<IntArray>.validDiag(x: Int, y: Int): Boolean {
    val d1 = this[y][x] + this[y + 1][x + 1] + this[y + 2][x + 2]
    val d2 = this[y][x + 2] + this[y + 1][x + 1] + this[y + 2][x]

    return d1 == 15 && d2 == 15
}

// https://leetcode.com/problems/magic-squares-in-grid/description/