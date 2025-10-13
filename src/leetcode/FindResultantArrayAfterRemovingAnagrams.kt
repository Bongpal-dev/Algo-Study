package leetcode

fun main() {
    val words1 = arrayOf("abba", "baba", "bbaa", "cd", "cd")
    val words2 = arrayOf("a", "b", "c", "d", "e")

    println(removeAnagrams(words1))
    println(removeAnagrams(words2))
}

private fun removeAnagrams(words: Array<String>): List<String> {
    val ans = mutableListOf(words[0])

    for (i in 1..words.lastIndex) {
        if (isAnagram(words[i], words[i - 1]).not()) {
            ans += words[i]
        }
    }

    return ans
}

private fun isAnagram(a: String, b: String): Boolean {
    if (a.length != b.length) return false

    val count = IntArray(26)

    for (c in a) count[c - 'a']++
    for (c in b) count[c - 'a']--

    return count.all { it == 0 }
}

// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/