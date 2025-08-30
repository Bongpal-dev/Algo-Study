package leetcode

import kotlin.math.absoluteValue

fun main() {
    val s1 = "hello"
    val s2 = "zaz"

    println(scoreOfString(s1))
    println(scoreOfString(s2))
}

private fun scoreOfString(s: String): Int {
    var answer = 0

    for(i in 0 .. s.length -2) {
        answer += (s[i].code - s[i+1].code).absoluteValue
    }

    return answer
}

// https://leetcode.com/problems/score-of-a-string/description/