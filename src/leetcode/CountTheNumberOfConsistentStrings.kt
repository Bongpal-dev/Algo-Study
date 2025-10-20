package leetcode

fun main() {
    val (allowed1, words1) = "ab" to arrayOf("ad", "bd", "aaab", "baa", "badab")
    val (allowed2, words2) = "abc" to arrayOf("a", "b", "c", "ab", "ac", "bc", "abc")
    val (allowed3, words3) = "cad" to arrayOf("cc", "acd", "b", "ba", "bac", "bad", "ac", "d")

    println(countConsistentStrings(allowed1, words1))
    println(countConsistentStrings(allowed2, words2))
    println(countConsistentStrings(allowed3, words3))
}

private fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    return words.count { Regex(".*[^${allowed}]+.*").matches(it).not() }
}

// https://leetcode.com/problems/count-the-number-of-consistent-strings/description/