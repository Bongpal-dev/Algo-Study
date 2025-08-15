package leetcode

fun main() {
    val num1 = 38
    val num2 = 0

    println(addDigits(num1))
    println(addDigits(num2))
}

private fun addDigits(num: Int): Int {
    if (num == 0) return 0

    return if (num % 9 == 0) 9 else num % 9
}

// https://leetcode.com/problems/add-digits/description/
