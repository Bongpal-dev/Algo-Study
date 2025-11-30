package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (s1, t1) = "abc" to "bac"
    val (s2, t2) = "abcde" to "edbac"

    println(findPermutationDifference(s1, t1))
    println(findPermutationDifference(s2, t2))
}

private fun findPermutationDifference(s: String, t: String): Int {
    val arr = IntArray(26)

    s.forEachIndexed { i, c -> arr[c - 'a'] = i }

    return t.foldIndexed(0) { i, acc, c ->
        val si = arr[c - 'a']
        val sub = (i - si).absoluteValue

        acc + sub
    }
}

// https://leetcode.com/problems/permutation-difference-between-two-strings/description/