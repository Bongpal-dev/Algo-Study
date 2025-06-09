package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (x1, n1) = 2.00000 to 10
    val (x2, n2) = 2.10000 to 3
    val (x3, n3) = 2.00000 to -2

    println(myPow(x1, n1))
    println(myPow(x2, n2))
    println(myPow(x3, n3))
}

private fun myPow(x: Double, n: Int): Double {
    var t = x
    var v = n.toLong()
    var answer = 1.0

    if(v < 0) {
        t = 1 / t
        v = -v
    }

    while(v > 0) {
        if(v %2 == 1L) answer *= t

        t *= t
        v /= 2
    }

    return answer
}

// https://leetcode.com/problems/powx-n/description/