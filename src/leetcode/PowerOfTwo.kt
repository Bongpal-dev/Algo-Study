package leetcode

fun main() {
    val n1 =1
    val n2 =16
    val n3 =3

    println(isPowerOfTwo(n1))
    println(isPowerOfTwo(n2))
    println(isPowerOfTwo(n3))
}

private fun isPowerOfTwo(n: Int): Boolean {
    if(n == 1) return true

    var r = 1L

    while (r < n) r *= 2L

    return r == n.toLong()
}

// https://leetcode.com/problems/power-of-two/description/