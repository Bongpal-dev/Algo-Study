package leetcode

fun main() {
    val digits1 = intArrayOf(1, 2, 3)
    val digits2 = intArrayOf(4,3,2,1)
    val digits3 = intArrayOf(9)
    val digits4 = intArrayOf(9, 9)

    println(plusOne(digits1).joinToString())
    println(plusOne(digits2).joinToString())
    println(plusOne(digits3).joinToString())
    println(plusOne(digits4).joinToString())
}

private fun plusOne(digits: IntArray): IntArray {
    var carry = 1

    for(i in digits.size - 1 downTo 0) {
        if(carry == 0) break

        val n = digits[i] + carry

        carry = n / 10
        digits[i] = n % 10
    }

    return if(carry == 1) intArrayOf(1) + digits else digits
}

// https://leetcode.com/problems/plus-one/description/