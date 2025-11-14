package leetcode

fun main() {
    val (n1, queries1) = 3 to arrayOf(intArrayOf(1, 1, 2, 2), intArrayOf(0, 0, 1, 1))
    val (n2, queries2) = 2 to arrayOf(intArrayOf(0, 0, 1, 1))

    println(rangeAddQueries(n1, queries1).joinToString("\n") { it.joinToString() })
    println(rangeAddQueries(n2, queries2).joinToString("\n") { it.joinToString() })
}

private fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
    val ans = Array(n) { IntArray(n) }

    queries.forEach { q ->
        for (i in q[0]..q[2]) {
            for (j in q[1]..q[3]) {
                ans[i][j]++
            }
        }
    }

    return ans
}

// https://leetcode.com/problems/increment-submatrices-by-one/description/