package leetcode

fun main() {
    val s1 = "babad"
    val s2 = "cbbd"

    println(longestPalindrome(s1))
    println(longestPalindrome(s2))
}

private fun longestPalindrome(s: String): String {
    var longest = ""

    for (i in s.indices) {
        val odd = findPalindrome(s, i, i)
        val even = findPalindrome(s, i, i + 1)
        val currentLongest = if(odd.length > even.length) odd else even

        if(currentLongest.length > longest.length) longest = currentLongest
    }

    return longest
}

private fun findPalindrome(s: String, left: Int, right: Int): String {
    var l = left
    var r = right

    while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
        l--
        r++
    }

    return s.substring(l + 1, r)
}

// https://leetcode.com/problems/longest-palindromic-substring/description/