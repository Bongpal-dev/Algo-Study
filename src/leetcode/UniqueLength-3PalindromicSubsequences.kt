package leetcode

fun main() {
    val s1 = "aabca"
    val s2 = "adc"
    val s3 = "bbcbaba"

    println(countPalindromicSubsequence(s1))
    println(countPalindromicSubsequence(s2))
    println(countPalindromicSubsequence(s3))
}

private fun countPalindromicSubsequence(s: String): Int {
    var ans = 0
    val p = hashSetOf<Char>()

    for (i in s.indices) {
        if (s[i] in p) continue

        val seen = hashSetOf<Char>()

        for (j in i + 1 until s.findLastIndex(s[i])) {
            if (s[j] !in seen) ans++

            seen += s[j]
        }

        p += s[i]
    }

    return ans
}

private fun String.findLastIndex(c: Char): Int {
    for (i in this.length - 1 downTo 0) {
        if (this[i] == c) return i
    }

    return -1
}

// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/