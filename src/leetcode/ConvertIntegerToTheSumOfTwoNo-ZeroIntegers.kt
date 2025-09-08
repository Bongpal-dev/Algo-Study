package leetcode

fun main() {
    val n1 = 2
    val n2 = 11
    val n3 = 1010

    println(getNoZeroIntegers(n1).joinToString())
    println(getNoZeroIntegers(n2).joinToString())
    println(getNoZeroIntegers(n3).joinToString())
}

private fun getNoZeroIntegers(n: Int): IntArray {
    for (i in 1..n) {
        val sub = n - i

        if(i.isNoZeroInt() && sub.isNoZeroInt()) return intArrayOf(i, sub)
    }

    return intArrayOf()
}

private fun Int.isNoZeroInt(): Boolean {
    var r = this

    while(r > 0) {
        if(r % 10 == 0) return false

        r /= 10
    }

    return true
}

// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description