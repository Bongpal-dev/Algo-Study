package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (numerator1, denominator1) = 1 to 2
    val (numerator2, denominator2) = 2 to 1
    val (numerator3, denominator3) = 4 to 333

    println(fractionToDecimal(numerator1, denominator1))
    println(fractionToDecimal(numerator2, denominator2))
    println(fractionToDecimal(numerator3, denominator3))
}

private fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (numerator == 0) return "0"

    val sb = StringBuilder()

    if (numerator.toLong() * denominator < 0) sb.append("-")

    val (n, d) = numerator.toLong().absoluteValue to denominator.toLong().absoluteValue

    sb.append(n / d)

    if (n % d != 0L) {
        sb.append(".")
        sb.append(belowPoint(n, d))
    }

    return sb.toString()
}

private fun belowPoint(n: Long, d: Long): String {
    val sb = StringBuilder()
    val map = hashMapOf<Long, Int>()
    var r = n % d

    while (r != 0L) {
        if (map.containsKey(r)) {
            sb.insert(map[r]!!, "(")
            sb.append(")")
            break
        }

        map[r] = sb.length
        r *= 10
        sb.append(r / d)
        r %= d
    }

    return sb.toString()
}

// https://leetcode.com/problems/fraction-to-recurring-decimal/description