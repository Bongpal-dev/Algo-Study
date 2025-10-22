package leetcode

fun main() {
    val s1 = "abc"
    val s2 = "zaza"

    println(reverseDegree(s1))
    println(reverseDegree(s2))
}

private fun reverseDegree(s: String) = s.mapIndexed { i, c -> ('z' + 1 - c) * (i + 1) }.sum()

// https://leetcode.com/problems/reverse-degree-of-a-string/description/