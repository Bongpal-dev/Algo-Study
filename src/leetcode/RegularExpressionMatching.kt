package leetcode

fun main() {
    val (s1, p1) = "aa" to "a"
    val (s2, p2) = "aa" to "a*"
    val (s3, p3) = "ab" to ".*"

    println(isMatch(s1, p1))
    println(isMatch(s2, p2))
    println(isMatch(s3, p3))
}

private fun isMatch(s: String, p: String): Boolean {
    return checkMatch(s, p, 0, 0)
}

private fun checkMatch(s: String, p: String, i: Int, j: Int): Boolean {
    if (j == p.length) return i == s.length

    if (j + 1 < p.length && p[j + 1] == '*') {
        if (checkMatch(s, p, i, j + 2)) return true

        if (i < s.length && (s[i] == p[j] || p[j] == '.')) {
            if (checkMatch(s, p, i + 1, j)) return true
        }

        return false
    }

    if (i < s.length && (s[i] == p[j] || p[j] == '.')) {
        return checkMatch(s, p, i + 1, j + 1)
    }

    return false
}

// https://leetcode.com/problems/regular-expression-matching/description/