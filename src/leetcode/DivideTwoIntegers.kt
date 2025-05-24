package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (dividend1, divisor1) = 10 to 3
    val (dividend2, divisor2) = 7 to -3
    val (dividend3, divisor3) = -1 to 1

    println(divide(dividend1, divisor1))
    println(divide(dividend2, divisor2))
    println(divide(dividend3, divisor3))
}

private fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE

    val isNegative = (dividend < 0) xor (divisor < 0)
    var remain = dividend.toLong().absoluteValue
    val d = divisor.toLong().absoluteValue
    var answer = 0L

    for(i in 31 downTo 0) {
        if ((remain.shr(i)) >= d) {
            remain -= d.shl(i)
            answer += 1L.shl(i)
        }
    }
    if (isNegative) answer *= -1

    return answer.coerceIn(Int.MIN_VALUE.toLong(), Int.MAX_VALUE.toLong()).toInt()
}

// https://leetcode.com/problems/divide-two-integers/description/