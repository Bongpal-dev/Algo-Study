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
    val board2 = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )
    val board3 = arrayOf(
        charArrayOf('.', '.', '.', '.', '5', '.', '.', '1', '.'),
        charArrayOf('.', '4', '.', '3', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '3', '.', '.', '1'),
        charArrayOf('8', '.', '.', '.', '.', '.', '.', '2', '.'),
        charArrayOf('.', '.', '2', '.', '7', '.', '.', '.', '.'),
        charArrayOf('.', '1', '5', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '2', '.', '.', '.'),
        charArrayOf('.', '2', '.', '9', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.'),
    )

    println(isValidSudoku(board1))
    println(isValidSudoku(board2))
    println(isValidSudoku(board3))
}

private fun isValidSudoku(board: Array<CharArray>): Boolean {
    val hashMap = hashMapOf<Char, MutableList<Pair<Int, Int>>>()

    for (y in board.indices) {
        for (x in board[0].indices) {
            if (board[y][x] == '.') continue

            val c = hashMap.getOrPut(board[y][x]) { mutableListOf() }

            if (c.any { it.first == y || it.second == x }) return false

            if (c.any { it.first / 3 == y / 3 && it.second / 3 == x / 3 }) return false

            hashMap[board[y][x]] = c.apply { add(Pair(y, x)) }
        }
    }

    return true
}

// https://leetcode.com/problems/valid-sudoku/description/