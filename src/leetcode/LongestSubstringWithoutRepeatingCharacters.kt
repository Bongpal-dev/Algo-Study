package leetcode

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring(" "))
    println(lengthOfLongestSubstring("au"))
    println(lengthOfLongestSubstring("dvdf"))
}

private fun lengthOfLongestSubstring(s: String): Int {
    if (s.length == 1) return 1

    val substring = hashMapOf<Char, Char>()
    var maxLength = 0

    for (c in s.indices) {
        for (d in c + 1..s.lastIndex) {
            substring[s[c]] = s[c]

            val subC = substring[s[d]]

            if (subC != null) {
                maxLength = maxOf(maxLength, substring.size)
                substring.clear()
                break
            } else {
                substring[s[d]] = s[d]
            }
        }
    }
    maxLength = maxOf(maxLength, substring.size)

    return maxLength
}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description