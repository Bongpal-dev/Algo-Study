package leetcode

fun main() {
    val (s11, s21, s31) = listOf("aabcc", "dbbca", "aadbbcbcac")
    val (s12, s22, s32) = listOf("aabcc", "dbbca", "aadbbbaccc")
    val (s13, s23, s33) = listOf("", "", "")

    println(isInterleave(s11, s21, s31))
    println(isInterleave(s12, s22, s32))
    println(isInterleave(s13, s23, s33))
}

private fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length) return false
    if (s1.isEmpty()) return s2 == s3
    if (s2.isEmpty()) return s1 == s3

    val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) }

    dp[0][0] = true

    for (i in 1..s1.length) {
        dp[i][0] = dp[i - 1][0] && s1[i - 1] == s3[i - 1]
    }

    for (j in 1..s2.length) {
        dp[0][j] = dp[0][j - 1] && s2[j - 1] == s3[j - 1]
    }

    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            dp[i][j] = (dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]) || (dp[i][j - 1] && s2[j - 1] == s3[i + j - 1])
        }
    }

    return dp[s1.length][s2.length]
}

// https://leetcode.com/problems/interleaving-string/description/