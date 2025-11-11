package leetcode

fun main() {
    val strs1 = arrayOf("10", "0001", "111001", "1", "0")
    val (m1, n1) = 5 to 3
    val strs2 = arrayOf("10", "0", "1")
    val (m2, n2) = 1 to 1

    println(findMaxForm(strs1, m1, n1))
    println(findMaxForm(strs2, m2, n2))
}

private fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
    val dp = Array(m + 1) { IntArray(n + 1) }

    for (s in strs) {
        val cz = s.count { it == '0' }
        val co = s.length - cz

        for (z in m downTo cz) {
            for (o in n downTo co) {
                dp[z][o] = maxOf(dp[z][o], dp[z - cz][o - co] + 1)
            }
        }
    }

    return dp[m][n]
}

// https://leetcode.com/problems/ones-and-zeroes/description/