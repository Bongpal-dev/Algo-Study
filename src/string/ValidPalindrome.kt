package string

private fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
    println(isPalindrome("0P"))
}

private fun isPalindrome(s: String): Boolean {
    var l = 0
    var r = s.length - 1

    while (l <= r) {
        if (s[l].isLetterOrDigit().not()) {
            l++
            continue
        }

        if (s[r].isLetterOrDigit().not()) {
            r--
            continue
        }

        if (s[l].lowercase() != s[r].lowercase()) return false

        l++
        r--
    }

    return true
}

// https://leetcode.com/problems/valid-palindrome/description/