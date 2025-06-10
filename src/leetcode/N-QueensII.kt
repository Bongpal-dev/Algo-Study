package leetcode

fun main() {
    val n1 = 4
    val n2 = 1

    println(totalNQueens(n1))
    println(totalNQueens(n2))
}

private fun totalNQueens(n: Int): Int {
    var count = 0
    val cols = BooleanArray(n)
    val diag1 = BooleanArray(2 * n)
    val diag2 = BooleanArray(2 * n)

    fun find(row: Int) {
        if(row == n) {
            count++
            return
        }

        for(col in 0..<n) {
            val d1 = row + col
            val d2 = row - col + n

            if(cols[col] || diag1[d1] || diag2[d2]) continue

            cols[col] = true
            diag1[d1] = true
            diag2[d2] = true

            find(row + 1)

            cols[col] = false
            diag1[d1] = false
            diag2[d2] = false
        }
    }

    find(0)

    return count
}

// https://leetcode.com/problems/n-queens-ii/description/