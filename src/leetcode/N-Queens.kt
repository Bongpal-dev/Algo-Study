package leetcode

fun main() {
    val n1 = 4
    val n2 = 1

    println(solveNQueens(n1).joinToString("\n==========\n") { it.joinToString("\n") })
    println(solveNQueens(n2).joinToString("\n==========\n") { it.joinToString("\n") })
}

private fun solveNQueens(n: Int): List<List<String>> {
    val results = mutableListOf<List<String>>()
    val column = BooleanArray(n)
    val diag1 = BooleanArray(2 * n)
    val diag2 = BooleanArray(2 * n)

    fun search(row: Int, board: MutableList<String>) {
        if (row == n) {
            results.add(board.toList())
            return
        }

        for (c in 0 until n) {
            val d1 = row + c
            val d2 = row - c + n

            if (column[c] || diag1[d1] || diag2[d2]) continue

            column[c] = true
            diag1[d1] = true
            diag2[d2] = true

            board.add(CharArray(n) { if (it == c) 'Q' else '.' }.joinToString(""))
            search(row + 1, board)

            board.removeLast()
            column[c] = false
            diag1[d1] = false
            diag2[d2] = false
        }
    }

    search(0, mutableListOf())

    return results
}

// https://leetcode.com/problems/n-queens/description/