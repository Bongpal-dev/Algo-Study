package leetcode

fun main() {
    val (board1, word1) = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    ) to "ABCCED"
    val (board2, word2) = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    ) to "SEE"
    val (board3, word3) = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    ) to "ABCB"

    println(exist(board1, word1))
    println(exist(board2, word2))
    println(exist(board3, word3))
}

private fun exist(board: Array<CharArray>, word: String): Boolean {
    val visited = Array(board.size) { BooleanArray(board[0].size) }

    for (y in board.indices) {
        for (x in board[0].indices) {
            if (find(x, y, board, word, 0, visited)) return true
        }
    }
    return false
}

private fun find(x: Int, y: Int, board: Array<CharArray>, word: String, i: Int, visited: Array<BooleanArray>): Boolean {
    if (x !in board[0].indices || y !in board.indices || board[y][x] != word[i] || visited[y][x]) return false
    if (i == word.length - 1 && board[y][x] == word[i]) return true

    val newI = if(board[y][x] == word[i]) i+1 else i

    visited[y][x] = true


    val l = find(x + 1, y, board, word, newI, visited)
    val r = find(x - 1, y, board, word, newI, visited)
    val b = find(x, y + 1, board, word, newI, visited)
    val t = find(x, y - 1, board, word, newI, visited)

    if(l || r|| b|| t) return true

    visited[y][x] = false

    return false
}

// https://leetcode.com/problems/word-search/description/z