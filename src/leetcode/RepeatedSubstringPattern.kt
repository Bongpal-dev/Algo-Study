package leetcode

fun main() {
    val s1 = "abab"
    val s2 = "aba"
    val s3 = "abcabcabcabc"
    val s4 = "ababab"

    println(repeatedSubstringPattern(s1))
    println(repeatedSubstringPattern(s2))
    println(repeatedSubstringPattern(s3))
    println(repeatedSubstringPattern(s4))
}

private fun repeatedSubstringPattern(s: String): Boolean {
    if (s.length <= 1) return false

    return buildLps(s).let { lps ->
        if (lps == 0) false else s.length % (s.length - lps) == 0
    }
}

private fun buildLps(p: String): Int {
    val lps = IntArray(p.length)
    var l = 0
    var i = 1

    while (i < p.length) {
        if (p[i] == p[l]) {
            l++
            lps[i] = l
            i++
        } else {
            if (l != 0) {
                l = lps[l - 1]
            } else {
                lps[i] = 0
                i++
            }
        }
    }
    return lps.last()
}

// https://leetcode.com/problems/repeated-substring-pattern/description/