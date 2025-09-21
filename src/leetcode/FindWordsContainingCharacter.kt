package leetcode

fun main() {
    val (words1, x1) = arrayOf("leet", "code") to 'e'
    val (words2, x2) = arrayOf("abc", "bcd", "aaaa", "cbc") to 'a'
    val (words3, x3) = arrayOf("abc", "bcd", "aaaa", "cbc") to 'z'

    println(findWordsContaining(words1, x1))
    println(findWordsContaining(words2, x2))
    println(findWordsContaining(words3, x3))
}

private fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    return words.mapIndexedNotNull { i, v -> if (v.contains(x)) i else null }
}

// https://leetcode.com/problems/find-words-containing-character/description/