package string

private fun main() {
    println(longestPalindrome("abccccdd"))
    println(longestPalindrome("aA"))
}

private fun longestPalindrome(s: String): Int {
    if (s.length == 1) return 1

    val counter = IntArray(52)
    var answer = 0

    for (c in s) {
        val idx = (if (c.isUpperCase()) c - 65 else c - 71).code

        counter[idx] += 1

        if (counter[idx] == 2) {
            counter[idx] = 0
            answer += 2
        }
    }

    if (counter.any { it != 0 }) answer++

    return answer
}

// https://leetcode.com/problems/longest-palindrome/description/