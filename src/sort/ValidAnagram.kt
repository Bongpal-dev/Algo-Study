package sort

fun main() {
    val (s1, t1) = "anagram" to "nagaram"
    val (s2, t2) = "rat" to "car"

    println(isAnagram(s1, t1))
    println(isAnagram(s2, t2))
}

private fun isAnagram(s: String, t: String): Boolean {
    return s.toCharArray().apply { sort() }.joinToString("") == t.toCharArray().apply { sort() }.joinToString("")
}

// https://leetcode.com/problems/valid-anagram/description/