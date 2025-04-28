package leetcode

fun main() {
    val (s1, t1) = "abc" to "ahbgdc"
    val (s2, t2) = "axc" to "ahbgdc"

    println(isSubsequence(s1, t1))
    println(isSubsequence(s2, t2))
}

private fun isSubsequence(s: String, t: String): Boolean {
    if (s.isBlank()) return true
    if (t.isBlank()) return false

    var i = 0

    for (c in t) {
        if (c == s[i]) i++

        if (i == s.length) return true
    }
    return false
}

// https://leetcode.com/problems/is-subsequence/description/