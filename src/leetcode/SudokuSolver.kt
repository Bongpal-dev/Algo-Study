package leetcode

fun main() {
    val board1 = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )

    solveSudoku(board1)

    println(board1.joinToString("\n") { it.joinToString(" | ") })
}

private fun solveSudoku(board: Array<CharArray>): Unit {
    board.findAnswer()
}

private fun Array<CharArray>.findAnswer(): Boolean {
    for (y in 0..8) {
        for (x in 0..8) {
            if (this[y][x] == '.') {
                for (n in '1'..'9') {
                    if(this.validSudoku(x, y, n)) {
                        this[y][x] = n
                        if(this.findAnswer()) return true
                        this[y][x] = '.'
                    }
                }
                return false
            }
        }
    }
    return true
}

private fun Array<CharArray>.validSudoku(x: Int, y: Int, t: Char): Boolean {
    for (i in 0..8) {
        if (this[y][i] == t) return false
        if (this[i][x] == t) return false

        val gx = (x / 3) * 3 + i / 3
        val gy = (y / 3) * 3 + i % 3

        if (this[gy][gx] == t) return false
    }
    return true
}

// https://leetcode.com/problems/sudoku-solver/description/