package leetcode

fun main() {
    val (word11, word21) = "horse" to "ros"
    val (word12, word22) = "intention" to "execution"
    val (word13, word23) = "zoologicoarchaeologist" to "zoogeologist"

    println(minDistance(word11, word21))
    println(minDistance(word12, word22))
    println(minDistance(word13, word23))
}

private fun minDistance(word1: String, word2: String): Int {
    val dp = Array(word2.length + 1) { i ->
        IntArray(word1.length + 1) { j ->
            when {
                i == 0 -> j
                j == 0 -> i
                else -> 0
            }
        }
    }

    for (y in 1..dp.lastIndex) {
        for (x in 1..dp[0].lastIndex) {
            dp[y][x] = if (word1[x - 1] == word2[y - 1]) {
                dp[y - 1][x - 1]
            } else {
                minOf(dp[y - 1][x], dp[y][x - 1], dp[y - 1][x - 1]) + 1
            }

        }
    }

    return dp.last().last()
}

// https://leetcode.com/problems/edit-distance/description/