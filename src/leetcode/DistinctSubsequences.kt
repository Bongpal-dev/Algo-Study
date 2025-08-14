package leetcode

fun main() {
    val (s1, t1) = "rabbbit" to "rabbit"
    val (s2, t2) = "babgbag" to "bag"

    println(numDistinct(s1, t1))
    println(numDistinct(s2, t2))
}

private fun numDistinct(s: String, t: String): Int {
    val dp = Array(s.length + 1) { LongArray(t.length + 1) { -1L } }

    return find(Str(s, 0), Str(t, 0), dp).toInt()
}

private fun find(s: Str, t: Str, dp: Array<LongArray>): Long {
    if (t.i == t.length) return 1L
    if (s.i == s.length) return 0L
    if (s.length - s.i < t.length - t.i) return 0L
    if (dp[s.i][t.i] != -1L) return dp[s.i][t.i]

    var result = find(Str(s.s, s.i + 1), t, dp)

    if (s.current == t.current) {
        result += find(Str(s.s, s.i + 1), Str(t.s, t.i + 1), dp)
    }
    dp[s.i][t.i] = result

    return result
}

private data class Str(
    val s: String,
    val i: Int,
    val length: Int = s.length
) {
    val current get() = s[i]
}

// https://leetcode.com/problems/distinct-subsequences/description/