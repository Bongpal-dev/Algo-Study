package bitcontroll

fun main() {
    val (a1, b1) = 1 to 2
    val (a2, b2) = 122 to 48 // 10101010

    println(getSum(a1, b1))
    println(getSum(a2, b2))
}

private fun getSum(a: Int, b: Int): Int {
    var sum = a.xor(b)
    var carry = a.and(b).shl(1)

    while (sum.and(carry) != 0){
        sum = sum.xor(carry).also { carry = sum.and(carry).shl(1) }
    }

    return sum.or(carry)
}

// https://leetcode.com/problems/sum-of-two-integers/description/