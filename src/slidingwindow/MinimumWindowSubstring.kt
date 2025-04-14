package slidingwindow

import java.time.temporal.IsoFields

fun main() {
    val (s1, t1) = "ADOBECODEBANC" to "ABC"
    val (s2, t2) = "a" to "a"
    val (s3, t3) = "a" to "aa"

    println(minWindow(s1, t1))
    println(minWindow(s2, t2))
    println(minWindow(s3, t3))
}

private fun minWindow(s: String, t: String): String {
    if (s.length < t.length) return ""

    val need = t.groupingBy { it }.eachCount()
    val window = mutableMapOf<Char, Int>()
    var valid = 0

    var l = 0
    var r = 0
    var answer = 100001
    var minStart = 0

    while (r < s.length) {
        val current = s[r]

        if (current in need) {
            window[current] = window.getOrDefault(current, 0) + 1

            if (window[current] == need[current]) valid++
        }
        r++

        while (valid == need.size) {
            if (r - l < answer) {
                answer = r - l
                minStart = l
            }

            val currentLeft = s[l]

            if (currentLeft in need) {
                if (window[currentLeft] == need[currentLeft]) valid--

                window[currentLeft] = window[currentLeft]!! - 1
            }
            l++
        }
    }

    return if (answer > 100000) "" else s.substring(minStart, minStart + answer)
}

// https://leetcode.com/problems/minimum-window-substring/description/