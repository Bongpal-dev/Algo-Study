package leetcode

fun main() {
    val num1 = 3749
    val num2 = 58
    val num3 = 1994

    println(intToRoman(num1))
    println(intToRoman(num2))
    println(intToRoman(num3))
}

private val romanNums = listOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I"
)

private fun intToRoman(num: Int): String {
    val sb = StringBuilder()

    romanNums.fold(num) { acc, (n, rn) ->
        val t = acc / n

        for (i in 0 until t) sb.append(rn)

        acc - (n * t)
    }

    return sb.toString()
}

// https://leetcode.com/problems/integer-to-roman/description/