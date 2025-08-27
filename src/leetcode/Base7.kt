package leetcode

import kotlin.math.absoluteValue

fun main() {
    val num1 = 100
    val num2 = -7

    println(convertToBase7(num1))
    println(convertToBase7(num2))
}

private fun convertToBase7(num: Int): String {
    if(num == 0) return "0"

    val sb = StringBuilder()
    var r = num.absoluteValue
    val negative = if (num < 0) "-" else ""

    while (r > 0) {
        sb.append(r % 7)
        r /= 7
    }

    return negative + sb.reverse().toString()
}

// https://leetcode.com/problems/base-7/description/