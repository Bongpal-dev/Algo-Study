package leetcode

fun main() {
    val s1 = "42"
    val s2 = "-042"
    val s3 = "1337c0d3"
    val s4 = "0-1"
    val s5 = "words and 987"

    println(myAtoi(s1))
    println(myAtoi(s2))
    println(myAtoi(s3))
    println(myAtoi(s4))
    println(myAtoi(s5))
}

private fun myAtoi(s: String): Int {
    if (s.isBlank()) return 0

    var answer = 0
    var sign = 1

    val v = s.trim()
    var i = 0

    when {
        v[i] == '+' -> {
            sign = 1
            i++
        }

        v[i] == '-' -> {
            sign = -1
            i++
        }

        v[i].isDigit().not() -> return 0
    }

    while (i < v.length && v[i].isDigit()) {
        val current = v[i] - '0'

        if (answer > (Int.MAX_VALUE - current) / 10) {
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }

        answer *= 10
        answer += current
        i++
    }

    return answer * sign
}

// https://leetcode.com/problems/string-to-integer-atoi/description/