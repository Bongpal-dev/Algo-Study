package leetcode

fun main() {
    val (words1, pref1) = arrayOf("pay","attention","practice","attend") to "at"
    val (words2, pref2) = arrayOf("leetcode","win","loops","success") to "code"

    println(prefixCount(words1, pref1))
    println(prefixCount(words2, pref2))
}

private fun prefixCount(words: Array<String>, pref: String): Int {
    return words.count { it.startsWith(pref) }
}

// https://leetcode.com/problems/counting-words-with-a-given-prefix/description/