package leetcode

fun main() {
    val (s1, p1) = "aa" to "a"
    val (s2, p2) = "aa" to "*"
    val (s3, p3) = "cb" to "?a"
    val (s4, p4) = "adceb" to "*a*b"
    val (s5, p5) = "" to "*****"

    println(isMatch(s1, p1))
    println(isMatch(s2, p2))
    println(isMatch(s3, p3))
    println(isMatch(s4, p4))
    println(isMatch(s5, p5))
}

private fun isMatch(s: String, p: String): Boolean {
    var (si, pi) = 0 to 0
    var st = -1
    var m = -1

    while(si < s.length) {
        when {
            pi < p.length && (p[pi] == s[si] || p[pi] == '?') -> {
                si++
                pi++
            }

            pi < p.length && p[pi] == '*' -> {
                st = pi
                m = si
                pi++
            }

            st != -1 -> {
                pi = st + 1
                m++
                si = m
            }

            else -> return false
        }
    }

    while(pi < p.length && p[pi] == '*') pi++

    return pi == p.length
}

// https://leetcode.com/problems/wildcard-matching/description/