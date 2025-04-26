package leetcode

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val x1 = 121
    val x2 = -121
    val x3 = 123456

    println(isPalindrome(x1))
    println(isPalindrome(x2))
    println(isPalindrome(x3))
}

private fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false

    var num = x
    var reverse = 0

    while (num > 0) {
        reverse *= 10
        reverse += num % 10
        num /= 10
    }

    return x == reverse
}

// http://leetcode.com/problems/palindrome-number/description/